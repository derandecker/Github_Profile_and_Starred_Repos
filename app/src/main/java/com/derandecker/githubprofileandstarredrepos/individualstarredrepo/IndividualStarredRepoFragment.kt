package com.derandecker.githubprofileandstarredrepos.individualstarredrepo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.derandecker.githubprofileandstarredrepos.R
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentIndividualStarredRepoBinding
import com.derandecker.githubprofileandstarredrepos.starredrepos.StarredReposFragmentArgs


class IndividualStarredRepoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentIndividualStarredRepoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_individual_starred_repo,
            container, false)

        val fullname = IndividualStarredRepoFragmentArgs.fromBundle(requireArguments()).fullName

//        viewModel.downloadIndividualStarredRepo(fullname)

        return binding.root
    }

}