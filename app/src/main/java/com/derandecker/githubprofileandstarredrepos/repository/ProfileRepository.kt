package com.derandecker.githubprofileandstarredrepos.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.derandecker.githubprofileandstarredrepos.GithubProfile
import com.derandecker.githubprofileandstarredrepos.database.GithubDatabase
import com.derandecker.githubprofileandstarredrepos.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileRepository(private val database: GithubDatabase) {


    fun getProfile(profileUsername: String): LiveData<GithubProfile> {
        return database.githubDao.getSelectedProfile(profileUsername)
    }


    suspend fun downloadProfile(username: String) {
        withContext(Dispatchers.IO) {
            val profile = Network.profile.getUserProfile(username)
            database.githubDao.insertProfile(profile)
        }
    }

}