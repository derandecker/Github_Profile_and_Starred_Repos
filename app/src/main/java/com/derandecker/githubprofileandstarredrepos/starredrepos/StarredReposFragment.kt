package com.derandecker.githubprofileandstarredrepos.starredrepos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.derandecker.githubprofileandstarredrepos.R
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentStarredReposBinding
import com.derandecker.githubprofileandstarredrepos.homescreen.HomeScreenViewModel
import com.derandecker.githubprofileandstarredrepos.homescreen.HomeScreenViewModelFactory

class StarredReposFragment : Fragment() {

    private val viewModel: StarredReposViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentStarredReposBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_starred_repos,
                container, false
            )

        val args = StarredReposFragmentArgs.fromBundle(
            requireArguments()
        )

        viewModel.downloadStarredRepos(args.username)

        viewModel.starredRepos.observe(viewLifecycleOwner, { repo ->
            repo?.forEach{
                Log.d("FOREACHREPO", it.full_name)
            }
        })

        return binding.root
    }


}