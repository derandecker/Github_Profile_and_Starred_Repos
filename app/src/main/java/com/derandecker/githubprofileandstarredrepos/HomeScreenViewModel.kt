package com.derandecker.githubprofileandstarredrepos

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.derandecker.githubprofileandstarredrepos.database.getDatabase
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val database = getDatabase(application)
    private val profileRepository = ProfileRepository(database)

    init {
        viewModelScope.launch {
            try {
                profileRepository.getProfile()
            } catch (e: Exception){
                Log.e("VIEWMODELSCOPE", "Error retrieving GitHub profile")
            }
        }
    }

    val profile: LiveData<GithubProfile> = profileRepository.profile
}