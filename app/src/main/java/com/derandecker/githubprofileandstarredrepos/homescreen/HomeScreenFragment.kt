package com.derandecker.githubprofileandstarredrepos.homescreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.derandecker.githubprofileandstarredrepos.R
import com.derandecker.githubprofileandstarredrepos.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment() {

    private val viewModel: HomeScreenViewModel by lazy {
        ViewModelProvider(
            this,
            HomeScreenViewModelFactory(requireActivity().application)
        ).get(HomeScreenViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHomeScreenBinding =
            DataBindingUtil.inflate(
                inflater, R.layout.fragment_home_screen,
                container, false
            )

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel


        binding.submitButton.setOnClickListener {
            viewModel.downloadProfile(binding.usernameEditText.text.toString())
            binding.showReposButton.visibility = View.VISIBLE
        }

        binding.showReposButton.setOnClickListener {
            this.findNavController()
                .navigate(
                    HomeScreenFragmentDirections.actionHomeScreenFragmentToStarredReposFragment(
                        binding.usernameEditText.text.toString()
                    )
                )
        }

        return binding.root
    }
}