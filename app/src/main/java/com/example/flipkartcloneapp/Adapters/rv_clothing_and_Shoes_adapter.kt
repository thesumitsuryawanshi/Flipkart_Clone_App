package com.example.flipkartcloneapp.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flipkartcloneapp.databinding.RvClothingandshoesBinding

class rv_clothing_and_Shoes_adapter(val category: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =
            RvClothingandshoesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return category.size
    }

    class ViewHolder(binding: RvClothingandshoesBinding) : RecyclerView.ViewHolder(binding.root) {
        val name = binding.tvDiscountOnCloths
    }
}