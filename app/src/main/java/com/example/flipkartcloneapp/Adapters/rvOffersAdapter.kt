package com.example.flipkartcloneapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartcloneapp.databinding.HRvOffersBinding

class rvOffersAdapter(val category: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = HRvOffersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val Cname = category[position]

    }

    override fun getItemCount(): Int {
        return category.size
    }

    class ViewHolder(binding: HRvOffersBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvOfferPrice
    }
}