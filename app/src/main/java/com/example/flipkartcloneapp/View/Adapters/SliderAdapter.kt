package com.example.flipkartcloneapp.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.databinding.ItemViewPagerBinding
import com.smarteist.autoimageslider.SliderViewAdapter

class SliderAdapter(val imagesList: List<Int>) :
    SliderViewAdapter<SliderAdapter.SliderViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?): SliderAdapter.SliderViewHolder {

        val view =
            ItemViewPagerBinding.inflate(LayoutInflater.from(parent!!.context), parent, false)
        val viewholder = SliderViewHolder(view)
        return viewholder
    }

    override fun onBindViewHolder(viewHolder: SliderAdapter.SliderViewHolder, position: Int) {
        val current_image = imagesList[position]
        Glide.with(viewHolder.iv_image).load(current_image)
            .fitCenter()
            .into(viewHolder.iv_image)
    }

    override fun getCount(): Int {
        return imagesList.size
    }

    inner class SliderViewHolder(binding: ItemViewPagerBinding) :
        SliderViewAdapter.ViewHolder(binding.root) {
        val iv_image = binding.ivImage
    }

}
