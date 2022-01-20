package com.derandecker.githubprofileandstarredrepos.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.derandecker.githubprofileandstarredrepos.model.GithubProfile

@Dao
interface GithubDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProfile(vararg profile: GithubProfile)

    @Query("SELECT * FROM githubprofile WHERE login = :login")
    fun getSelectedProfile(login: String): LiveData<GithubProfile>
    
}