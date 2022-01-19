package com.derandecker.githubprofileandstarredrepos.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.derandecker.githubprofileandstarredrepos.GithubProfile
import com.derandecker.githubprofileandstarredrepos.database.GithubDatabase
import com.derandecker.githubprofileandstarredrepos.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProfileRepository(private val database: GithubDatabase) {

    //TODO pass in username instead of hardcoding
    val profile: LiveData<GithubProfile> =
        database.githubDao.getSelectedProfile("derandecker")

    suspend fun downloadProfile(username: String) {
        withContext(Dispatchers.IO) {
            val profile = Network.profile.getUserProfile(username)
            database.githubDao.insertProfile(profile)
        }
    }

}