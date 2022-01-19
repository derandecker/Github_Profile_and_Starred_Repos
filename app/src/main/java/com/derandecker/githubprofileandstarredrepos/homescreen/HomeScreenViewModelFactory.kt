package com.derandecker.githubprofileandstarredrepos.homescreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeScreenViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeScreenViewModel(app) as T
        }
        throw IllegalArgumentException("Unable to construct viewmodel")
    }
}