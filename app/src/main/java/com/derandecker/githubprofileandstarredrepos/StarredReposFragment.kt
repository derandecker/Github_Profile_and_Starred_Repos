package com.derandecker.githubprofileandstarredrepos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentHomeScreenBinding
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentStarredReposBinding

class StarredReposFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentStarredReposBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_starred_repos,
            container, false)
        return binding.root
    }

}