package com.derandecker.githubprofileandstarredrepos

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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
    ): View? {
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

            return binding.root
    }
}