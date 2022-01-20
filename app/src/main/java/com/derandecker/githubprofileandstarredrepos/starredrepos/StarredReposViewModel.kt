package com.derandecker.githubprofileandstarredrepos.starredrepos

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.derandecker.githubprofileandstarredrepos.model.StarredRepo
import com.derandecker.githubprofileandstarredrepos.network.Network
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class StarredReposViewModel : ViewModel() {
    private val _starredRepos = MutableLiveData<List<StarredRepo>>()
    val starredRepos: LiveData<List<StarredRepo>>
        get() = _starredRepos

    fun downloadStarredRepos(username: String) {
        viewModelScope.launch{
            try {
                _starredRepos.value = Network.profile.getStarredRepos(username)
            } catch (e: Exception) {
                Log.e("VIEWMODELSCOPE", "Error retrieving Starred Repos")
            }
        }
    }
}