package com.example.oau_barter.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oau_barter.R
import com.example.oau_barter.databinding.FeedBinding
import com.example.oau_barter.extensions.ContextExtensions.showSnackbar
import com.example.oau_barter.modules.PostItemModel
import com.example.oau_barter.recyclers.FeedRecycler

class FeedFragment: Fragment() {    //used in binding view
    private var _binding: FeedBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: FeedRecycler
    private val data = mutableListOf<PostItemModel>()//list used in recycler

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setUpAdapter()
        super.onViewCreated(view, savedInstanceState)
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

   /** fun handleBundle(bundle: Bundle){ //you stop here
        if (bundle!=null){
            val

        }
    }**/

    fun setUpAdapter(){// handles the feed page recycleradapter
       val image = requireArguments().getString("image")
       val tag = "Books"
       val item_description = "I want to sell this new book"
       val price = "200 naira"
       val dataItem = PostItemModel(
           "Arafat", item_description, mutableListOf("Books", "Gadgets"),
           image?.toUri(), listOf(image?.toUri(), image?.toUri(), image?.toUri()), price
       )
       val list = mutableListOf<PostItemModel>()
       for (i in 1..10) {
           list.add(dataItem)
       }
        adapter = FeedRecycler(list)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(),
        LinearLayoutManager.VERTICAL, false)
    }
}