package com.example.flipkartcloneapp.View.Adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.AllProducts
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.RvMoreItemsBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class rv_AllItemsAdapter(val pList: List<AllProducts>) :
    RecyclerView.Adapter<rv_AllItemsAdapter.AllItemsAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemsAdapterViewHolder {
        val view = RvMoreItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = AllItemsAdapterViewHolder(view)


        return viewholder
    }

    override fun onBindViewHolder(holder: AllItemsAdapterViewHolder, position: Int) {
        val product = pList[position]

        holder.tvTitle.text = product.title
        holder.tvPrice.text = product.price
        holder.bindImage(product.img)

        val currentItem = AllProducts(
            img = product.img,
            title = product.title,
            price = product.price
        )

        holder.itemView.rootView.setOnClickListener {

            Snackbar.make(
                holder.itemView.rootView,
                "This goes to ShowProductFrag ",
                Snackbar.LENGTH_SHORT
            ).show()

            val value = currentItem
            val bundle = Bundle()
            bundle.putString("currentItem", Gson().toJson(value))
            Navigation.findNavController(it).navigate(R.id.action_global_to_showProductFrag,bundle)
        }
    }

    override fun getItemCount(): Int {
        return pList.size
    }

    class AllItemsAdapterViewHolder(binding: RvMoreItemsBinding) :
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

