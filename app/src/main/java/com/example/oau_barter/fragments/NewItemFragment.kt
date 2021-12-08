package com.example.oau_barter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.oau_barter.databinding.NewItemBinding


class NewItemFragment:Fragment() {//used in binding view
   private var _binding :NewItemBinding? =null
   private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        _binding = NewItemBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)//important for a fragement to implement the menu
        return binding.root
    }


    override fun onDestroyView() {//destroy previous view
        _binding = null
        super.onDestroyView()
    }
}
