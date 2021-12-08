package com.example.oau_barter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.oau_barter.R
import com.example.oau_barter.databinding.LoginBinding
import com.example.oau_barter.extensions.ContextExtensions
import com.example.oau_barter.extensions.ContextExtensions.showSnackbar
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() { //used in binding view
    private var _binding: LoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//allow action on the  layout i.e textview ...e.t.c.
        clickListeners()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    fun clickListeners() {   //hold all listener for all buttons on the page
        binding.apply {  //used to apply the binding variable function
            signUp.setOnClickListener {
                if (userName.text.toString().trim().isEmpty()) {
                    requireContext().showSnackbar("Enter Username", root)//used to call context store object
                    return@setOnClickListener
                }
                if (email.text.toString().trim().isEmpty()) {
                    requireContext().showSnackbar("Enter Email", root)
                    return@setOnClickListener
                }
                if (password.text.toString().trim().isEmpty()) {
                    requireContext().showSnackbar("Enter Password", root)
                    return@setOnClickListener
                } else findNavController().navigate(LoginFragmentDirections.actionGlobalUserSetupFragment())
            }
            signIn.setOnClickListener {
                if (email.text.toString().trim().isEmpty()) {
                    requireContext().showSnackbar("Enter Email", root)
                    return@setOnClickListener
                }
                if (password.text.toString().trim().isEmpty()) {
                    requireContext().showSnackbar("Enter Password", root)
                    return@setOnClickListener
                } else findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToFeedFragment())

            }

            forgotPassword.setOnClickListener {
                if (email.text.toString().trim().isEmpty()) {
                    requireContext().showSnackbar("Enter Email", root)
                    return@setOnClickListener
                } else findNavController().navigate(LoginFragmentDirections.actionGlobalUserSetupFragment())
            }
        }


    }
}