package com.example.oau_barter.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.oau_barter.R
import com.example.oau_barter.databinding.FeedBinding
import com.example.oau_barter.databinding.LoginBinding
import com.example.oau_barter.databinding.SplashScreenBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("CustomSplashScreen")
class SplashScreenFragment : Fragment() { //uses to binding view
    private var _binding: SplashScreenBinding? = null
    private val binding get() = _binding!!

    var userAccount = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SplashScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {//destroy previous view
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        checkUser()
        super.onViewCreated(view, savedInstanceState)
    }

    fun checkUser() { //check if user is logged in to select start page
        lifecycleScope.launch {
            delay(1500)
            if (userAccount) {
                findNavController().navigate(SplashScreenFragmentDirections.actionSlpashScreenFragmentToFeedFragment())

            } else {
                findNavController().graph.startDestination = R.id.loginFragment
                findNavController().navigate(SplashScreenFragmentDirections.actionSlpashScreenFragmentToLoginFragment())

            }

        }
    }
}