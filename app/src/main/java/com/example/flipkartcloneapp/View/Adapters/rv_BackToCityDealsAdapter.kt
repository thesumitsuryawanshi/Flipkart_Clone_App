package com.example.flipkartcloneapp.View.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.backToCityDeals
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.RvBackToCityDealsBinding
import com.google.gson.Gson

class rv_BackToCityDealsAdapter(val btcData: List<backToCityDeals>, val context: Context) :
    RecyclerView.Adapter<rv_BackToCityDealsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            RvBackToCityDealsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val _data = btcData[position]

        holder.tvDiscount.text = _data.percentage
        holder.bindImage(_data.imgUrl)

        holder.itemView.setOnClickListener {
            val value= "btcDeals_value"
            val bundle = Bundle()
            bundle.putString("btcDeals_key", Gson().toJson(value))
            Navigation.findNavController(it).navigate(R.id.GlobalActionTAllProductsFrag, bundle)
        }
    }

    override fun getItemCount(): Int {
        return btcData.size
    }

    class ViewHolder(binding: RvBackToCityDealsBinding) : RecyclerView.ViewHolder(binding.root) {

        val tvDiscount = binding.tvDiscount
        val tvImg = binding.watchImg

        fun bindImage(imageUrl: String) {
            Glide.with(itemView)
                .load(imageUrl)
                .into(tvImg)
        }
    }
}