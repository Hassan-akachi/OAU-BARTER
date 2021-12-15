package com.example.oau_barter.fragments

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.oau_barter.R
import com.example.oau_barter.databinding.NewItemBinding
import com.example.oau_barter.extensions.ContextExtensions.showSnackbar
import com.example.oau_barter.modules.PostItemModel
import com.example.oau_barter.recyclers.ImageRecycler
import com.theartofdev.edmodo.cropper.CropImage
import com.theartofdev.edmodo.cropper.CropImageView


class NewItemFragment:Fragment() {//used in binding view
   private var _binding :NewItemBinding? =null
   private val binding get() = _binding!!
    private val images = mutableListOf<Uri>()
    private lateinit var imagesAdapter: ImageRecycler

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        _binding = NewItemBinding.inflate(inflater, container, false)
        setHasOptionsMenu(true)//important for a fragement to implement the menu
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chooseImage()
        setUpAdapter()

        super.onViewCreated(view, savedInstanceState)
    }

    fun chooseImage(){
        binding.imageText.setOnClickListener {
        CropImage.activity()
            .setGuidelines(CropImageView.Guidelines.ON)
            .start(requireContext(), this)

    }
    }

    fun done(){
        binding.apply {
            done.setOnClickListener {
                val tag = this.tag.text.toString()
                val item_description = this.description.text.toString().trim()
                val price = this.price.text.toString().trim()
                val dataItem = PostItemModel("Arafat", item_description, mutableListOf("Books", "Gadgets"),
                    images[0].toString(), images, price
                )
                val list = mutableListOf<PostItemModel>()
                for (i in 1..10){
                    list.add(dataItem)
                }
                val bundle = Bundle()
                bundle.putString("profileName", "Arafat")
                bundle.putString("ItemDes", item_description)
                bundle.putStringArray("tags", arrayOf("Books", "Gadgets"))
                bundle.putString("image", images[0].toString())
                bundle.putString("price", price)
                findNavController().navigate(R.id.feedFragment, bundle)
            }
        }
    }

    fun setUpAdapter(){
        imagesAdapter = ImageRecycler(images = images)
        binding.apply {
            recycler.adapter = imagesAdapter
            val layoutManager = LinearLayoutManager(requireContext())
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recycler.layoutManager = layoutManager
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            val result:CropImage.ActivityResult = CropImage.getActivityResult(data)
            if (resultCode == RESULT_OK){
                images.add(result.uri)
                imagesAdapter.notifyItemInserted(images.size+1)
            }
            else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
               val error:Exception = result.error
                requireContext().showSnackbar("We couldn't fetch image.", binding.root)

            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroyView() {//destroy previous view
        _binding = null
        super.onDestroyView()
    }
}
