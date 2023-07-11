package com.example.flipkartcloneapp.View.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.databinding.RvMoreItemsBinding
import com.google.android.material.snackbar.Snackbar

class rv_AllItemsAdapter(
    val pList: List<String>,
    val ImgList: List<Int>,
    private val listener: ItemsCLickedFromAllProducts
) :
    RecyclerView.Adapter<rv_AllItemsAdapter.AllItemsAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllItemsAdapterViewHolder {
        val view = RvMoreItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = AllItemsAdapterViewHolder(view)


        return viewholder
    }

    override fun onBindViewHolder(holder: AllItemsAdapterViewHolder, position: Int) {
        val product = pList[position]
        val productImg = ImgList[position]

        holder.tvTitle.text = product
        holder.bindImage(productImg)


        holder.itemView.rootView.setOnClickListener {
            listener?.ClickedItemFromAllProducts(product[1].toString())

            Snackbar.make(
                holder.itemView.rootView,
                "  this goes to ShowProductFrag ",
                Snackbar.LENGTH_SHORT
            ).show()
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

        fun bindImage(imageUrl: Int) {
            Glide.with(itemView)
                .load(imageUrl)
                .into(tvImg)
        }
    }

    interface ItemsCLickedFromAllProducts {
        fun ClickedItemFromAllProducts(item: String) {
        }

    }

}

