package com.example.flipkartcloneapp.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.databinding.RvMoreItemsBinding

class rv_moreItemsAdapter(val pList: List<ProductList>) :
    RecyclerView.Adapter<rv_moreItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = RvMoreItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = pList[position]
        holder.tvTitle.text = product.pTitle
        holder.tvPrice.text = product.pActualPrice
        holder.bindImage(product.pImgUrl)
    }


    override fun getItemCount(): Int {
        return pList.size
    }

    class ViewHolder(binding: RvMoreItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val tvTitle = binding.tvTitle
        val tvPrice = binding.tvPrice
        val tvImg = binding.watchImg

        fun bindImage(imageUrl: String) {
            Glide.with(itemView)
                .load(imageUrl)
                .into(tvImg)
        }
    }

}