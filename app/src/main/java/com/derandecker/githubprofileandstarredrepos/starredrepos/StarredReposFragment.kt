package com.derandecker.githubprofileandstarredrepos.starredrepos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.derandecker.githubprofileandstarredrepos.R
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentStarredReposBinding

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

        val args = StarredReposFragmentArgs.fromBundle(requireArguments())

        val manager = LinearLayoutManager(context)
        binding.starredRepoRecyclerView.layoutManager = manager

        val viewModelAdapter = StarredReposRecyclerViewAdapter(StarredRepoListener { repo ->
            this.findNavController().navigate(
                StarredReposFragmentDirections
                    .actionStarredReposFragmentToIndividualStarredRepoFragment(repo.full_name)
            )
        })

        binding.starredRepoRecyclerView.adapter = viewModelAdapter


        viewModel.downloadStarredRepos(args.username)

        viewModel.starredRepos.observe(viewLifecycleOwner, { repos ->
            viewModelAdapter.submitList(repos)
        })


        return binding.root
    }


}