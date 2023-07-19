package com.example.flipkartcloneapp.View.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.BrandDealsList
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.RvBrandDealsBinding
import com.google.gson.Gson


class rv_brandDeals(val BDdata: List<BrandDealsList>, val context: Context) :
    RecyclerView.Adapter<rv_brandDeals.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = RvBrandDealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = BDdata[position]
        holder.bindImage(product.imgUrl)

        holder.itemView.setOnClickListener {
            val value = "brandDeals"
            val bundle = Bundle()
            bundle.putString("brandDeals_key", Gson().toJson(value ))
            Navigation.findNavController(it).navigate(R.id.GlobalActionTAllProductsFrag, bundle)
        }
    }

    override fun getItemCount(): Int {
        return BDdata.size
    }

    class ViewHolder(binding: RvBrandDealsBinding) : RecyclerView.ViewHolder(binding.root) {

        val tvDiscount = binding.tvDiscountOnCloths
        val imgUrl = binding.watchImg

        fun bindImage(imageUrl: String) {
            Glide.with(itemView)
                .load(imageUrl)
                .into(imgUrl)
        }
    }
}