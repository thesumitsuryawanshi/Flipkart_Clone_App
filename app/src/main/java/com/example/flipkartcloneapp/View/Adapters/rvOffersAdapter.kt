package com.example.flipkartcloneapp.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.Offers
import com.example.flipkartcloneapp.databinding.HRvOffersBinding

class rvOffersAdapter(val offerList: List<Offers>) :
    RecyclerView.Adapter<rvOffersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = HRvOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val product = offerList[position]
        holder.tvOffer.text = product.percentage
        holder.bindImage(product.imgUrl)

    }

    override fun getItemCount(): Int {
        return offerList.size
    }

    class ViewHolder(binding: HRvOffersBinding) : RecyclerView.ViewHolder(binding.root) {

        val tvOffer = binding.tvDiscount
        val tvImg = binding.watchImg

        fun bindImage(imageUrl: String) {
            Glide.with(itemView)
                .load(imageUrl)
                .into(tvImg)
        }
    }
}