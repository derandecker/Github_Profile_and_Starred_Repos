package com.derandecker.githubprofileandstarredrepos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentHomeScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home_screen,
            container, false)
        return binding.root
    }
}