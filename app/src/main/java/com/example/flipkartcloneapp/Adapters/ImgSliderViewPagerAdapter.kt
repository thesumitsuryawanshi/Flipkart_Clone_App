package com.example.flipkartcloneapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartcloneapp.databinding.ItemViewPagerBinding

class ImgSliderViewPagerAdapter(val images: List<Int>) :
    RecyclerView.Adapter<ImgSliderViewPagerAdapter.ViewPagerViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {

        val view = ItemViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewPagerViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {

        val current_image = images[position]
        holder.iv_image.setImageResource(current_image)

    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class ViewPagerViewHolder(binding: ItemViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val iv_image = binding.ivImage

    }
}