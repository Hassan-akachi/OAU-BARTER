package com.example.oau_barter.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.oau_barter.R
import com.example.oau_barter.databinding.FeedBinding
import com.example.oau_barter.databinding.LoginBinding
import com.example.oau_barter.extensions.ContextExtensions.showSnackbar

class FeedFragment: Fragment() {    //used in binding view
    private var _binding: FeedBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FeedBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true) //important for a fragement to implement the menu
        return binding.root
    }

    override fun onDestroyView() {//destroy previous view
        _binding = null
        super.onDestroyView()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.feed_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.search -> {    // to hadle search query
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{  //do this when the search query is clicked
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        searchView.clearFocus() //resize the layout back to an icon
                        handleSearch(query)
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
//                     do nothing
                        return false
                    }
                })
            }

            R.id.profile -> findNavController().navigate(FeedFragmentDirections.actionGlobalUserSetupFragment())
            R.id.trade -> findNavController().navigate(FeedFragmentDirections.actionFeedFragmentToNewItemFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    fun handleSearch(query:String?){    //method handle search queries
        if (query?.isEmpty() == true){
            requireContext().showSnackbar("Enter keyword", binding.root)
            return
        }

    }
}