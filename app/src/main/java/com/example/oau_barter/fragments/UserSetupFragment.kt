package com.example.oau_barter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.oau_barter.databinding.UserSetupBinding

class UserSetupFragment : Fragment() {  //uses to binding view
    private var _binding:UserSetupBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserSetupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {  //destroy previous view

        _binding=null
        super.onDestroyView()
    }
}