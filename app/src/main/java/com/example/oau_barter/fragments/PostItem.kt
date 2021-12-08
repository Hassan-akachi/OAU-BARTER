package com.example.oau_barter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.oau_barter.databinding.LoginBinding
import com.example.oau_barter.databinding.PostItemBinding

class PostItem: Fragment() {    //used in binding view
    private var _binding: PostItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(// for creating viewings in fragment
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PostItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {  //destroy previous view

        _binding = null
        super.onDestroyView()
    }
}