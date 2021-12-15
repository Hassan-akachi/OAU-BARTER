package com.example.oau_barter.recyclers

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.oau_barter.R
import com.example.oau_barter.databinding.ImageViewBinding

class ImageRecycler(val images: MutableList<Uri>? = null
, val feedImage:List<Uri>? = null) : RecyclerView.Adapter<ImageRecycler.ImageViewHolder>() {

    inner class ImageViewHolder(val binding: ImageViewBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int){//used to bind the view to layout
            binding.apply {
                Glide.with(itemView)
                    .load(images!![position])
                    .fitCenter()
                    .into(imageItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {//view inflated
        val view = ImageViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return (ImageViewHolder(view))
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return images!!.size
    }
}