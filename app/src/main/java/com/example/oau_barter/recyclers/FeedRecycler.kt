package com.example.oau_barter.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.example.oau_barter.databinding.PostItemBinding
import com.example.oau_barter.modules.PostItemModel

class FeedRecycler(val listOfData: List<PostItemModel>): Adapter<FeedRecycler.FeedViewHolder>() {


    inner class FeedViewHolder(val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root) {//holds the all bind views

            fun bind(position: Int){
                val imageRecycler = ImageRecycler(images = null, feedImage = listOfData[position].itemImageList)
                 val layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                    binding.apply {
                        Glide.with(itemView)
                            .load(listOfData[position].profilePic)
                            .into(profilePic)
                        userName.text = listOfData[position].profileName
                        info.text = listOfData[position].description
                        category.text = listOfData[position].tags[0]
                        recycler.adapter = imageRecycler
                        recycler.layoutManager = layoutManager
                    }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
      val postItemView= PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return (FeedViewHolder(postItemView))
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
      return listOfData.size
    }
}