package com.example.oau_barter.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.bumptech.glide.Glide
import com.example.oau_barter.databinding.PostItemBinding
import com.example.oau_barter.modules.PostItemModel

class FeedRecycler(val postItemModel: List<PostItemModel>): Adapter<FeedRecycler.FeedViewHolder>() {


    inner class FeedViewHolder(val binding: PostItemBinding): RecyclerView.ViewHolder(binding.root) {//holds the all bind views
        private val imageRecycler = ImageRecycler(images = null, feedImage = postItemModel[layoutPosition].itemImageList)
        private val layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            fun bind(position: Int){
                    binding.apply {
                        Glide.with(itemView)
                            .load(postItemModel[position].profilePic)
                            .into(profilePic)
                        userName.text = postItemModel[position].profileName
                        info.text = postItemModel[position].description
                        category.text = postItemModel[position].tags[0]
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
      return postItemModel.size
    }
}