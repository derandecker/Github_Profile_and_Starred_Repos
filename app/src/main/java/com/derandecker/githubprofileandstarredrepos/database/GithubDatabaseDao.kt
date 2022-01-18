package com.derandecker.githubprofileandstarredrepos.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.derandecker.githubprofileandstarredrepos.GithubProfile

@Dao
interface GithubDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(vararg profile: GithubProfile)

    @Query("SELECT * FROM githubprofile WHERE id = :id")
    fun getSelectedProfile(id: Long): GithubProfile
    
}