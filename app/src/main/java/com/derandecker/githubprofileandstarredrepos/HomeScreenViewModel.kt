package com.derandecker.githubprofileandstarredrepos

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.derandecker.githubprofileandstarredrepos.database.getDatabase
import com.derandecker.githubprofileandstarredrepos.repository.ProfileRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val database = getDatabase(application)
    private val profileRepository = ProfileRepository(database)
    private val query = MutableLiveData<String>()

    val profile: LiveData<GithubProfile> = Transformations.switchMap(
        query,
        ::temp
    )

    private fun temp(username: String) = profileRepository.getProfile(username)

    private fun updateProfile(profileUsername: String) = apply { query.value = profileUsername }

    fun downloadProfile(username: String) {
        viewModelScope.launch {
            try {
                profileRepository.downloadProfile(username)
            } catch (e: Exception) {
                Log.e("VIEWMODELSCOPE", "Error retrieving GitHub profile")
            }
            updateProfile(username)
        }

    }

}