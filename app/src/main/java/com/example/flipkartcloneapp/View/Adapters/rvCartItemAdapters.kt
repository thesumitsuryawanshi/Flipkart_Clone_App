package com.example.flipkartcloneapp.View.Adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.AllProducts
import com.example.flipkartcloneapp.databinding.RvMycartItemsBinding
import com.example.flipkartcloneapp.databinding.RvNotificationsItemsBinding

class rvCartItemAdapters(val IconList: List<Int> , val NamesList: List<String> , val PriceList: List<String> , val context: Context) :
    RecyclerView.Adapter<rvCartItemAdapters.CartViewHolder>() {

    lateinit var binding: RvMycartItemsBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {

        val view = RvMycartItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = CartViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val img  = IconList[position]
        val name = NamesList[position]
        val price = PriceList[position]

        holder.name.text = name
        holder.tvPrice.text = price

        Glide.with(context)
            .load(img)
            .into(holder.img)
    }

    override fun getItemCount(): Int { return IconList.size }

    class CartViewHolder(binding: RvMycartItemsBinding) : RecyclerView.ViewHolder(binding.root) {
         var tvPrice = binding.tvItemCost
         var name = binding.tvCartItemText
         var img = binding.ivSmNotificationsIcons
    }

}