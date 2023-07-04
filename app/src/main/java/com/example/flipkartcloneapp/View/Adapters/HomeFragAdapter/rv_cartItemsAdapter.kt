package com.example.flipkartcloneapp.View.Adapters.HomeFragAdapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.cartItems
import com.example.flipkartcloneapp.databinding.RvMycartItemsBinding

class rv_cartItemsAdapter(var cartItemList: cartItems) :
    RecyclerView.Adapter<rv_cartItemsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view =
            RvMycartItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = ViewHolder(view)

        return viewholder

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val _data = cartItemList

        holder.pname.text = _data.pTitle
        holder.bindImage(_data.pImgUrl)
        holder.pPrice.text = _data.pPrice
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(binding: RvMycartItemsBinding) : RecyclerView.ViewHolder(binding.root) {
        val pPrice = binding.tvItemCost
        val pname = binding.tvText
        val ivImg = binding.ivItemimage


        fun bindImage(imageUrl: String) {
            Glide.with(itemView)
                .load(imageUrl)
                .into(ivImg)
        }

    }


}