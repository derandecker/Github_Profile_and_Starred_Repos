package com.derandecker.githubprofileandstarredrepos.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.derandecker.githubprofileandstarredrepos.GithubProfile

@Database(entities = [GithubProfile::class], version = 1)
abstract class GithubDatabase : RoomDatabase() {
    abstract val githubDao: GithubDatabaseDao
}

private lateinit var INSTANCE: GithubDatabase

fun getDatabase(context: Context): GithubDatabase {
    synchronized(GithubDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                GithubDatabase::class.java,
                "profiles").build()
        }
    }
    return INSTANCE
}