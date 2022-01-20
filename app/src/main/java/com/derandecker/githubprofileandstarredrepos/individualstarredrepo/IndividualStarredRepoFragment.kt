package com.derandecker.githubprofileandstarredrepos.individualstarredrepo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.derandecker.githubprofileandstarredrepos.R
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentIndividualStarredRepoBinding


class IndividualStarredRepoFragment : Fragment() {

    private val viewModel: IndividualStarredRepoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentIndividualStarredRepoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_individual_starred_repo,
            container, false)


        val fullname = IndividualStarredRepoFragmentArgs.fromBundle(requireArguments()).fullName

        viewModel.downloadIndividualStarredRepo(fullname)

        viewModel.individualStarredRepo.observe(viewLifecycleOwner, { repo ->
            binding.repo = repo
        })


        return binding.root
    }

}