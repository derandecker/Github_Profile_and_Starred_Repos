package com.derandecker.githubprofileandstarredrepos.individualstarredrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.derandecker.githubprofileandstarredrepos.model.IndividualStarredRepo
import com.derandecker.githubprofileandstarredrepos.network.Network
import kotlinx.coroutines.launch

class IndividualStarredRepoViewModel : ViewModel() {
    private val _individualStarredRepo = MutableLiveData<IndividualStarredRepo>()
    val individualStarredRepo: LiveData<IndividualStarredRepo>
        get() = _individualStarredRepo

    fun downloadIndividualStarredRepo(username: String) {
        viewModelScope.launch{
            try {
                val splitString = username.split("/")
                _individualStarredRepo.value = Network.profile.getIndividualStarredRepo(splitString[0], splitString[1])
            } catch (e: Exception) {
                Log.e("VIEWMODELSCOPE", "Error retrieving repo")
            }
        }
    }
}