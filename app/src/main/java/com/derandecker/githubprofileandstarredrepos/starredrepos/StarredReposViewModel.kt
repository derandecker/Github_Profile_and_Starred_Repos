package com.derandecker.githubprofileandstarredrepos.starredrepos

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
            _starredRepos.value = Network.profile.getStarredRepos(username)
        }
    }
}