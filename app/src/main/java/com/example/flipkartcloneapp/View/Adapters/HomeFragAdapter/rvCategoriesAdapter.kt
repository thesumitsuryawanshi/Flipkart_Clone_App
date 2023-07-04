package com.example.flipkartcloneapp.View.Adapters.HomeFragAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.databinding.HRvCategoriesBinding

class rvCategoriesAdapter(
    val category: List<String>,
    val ImgList: List<Int>,
    val context: Context
) : RecyclerView.Adapter<rvCategoriesAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = HRvCategoriesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val viewholder = CategoryViewHolder(view)
        return viewholder
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val _Cname = category[position]
        val _currentImg = ImgList[position]

        holder.name.text = _Cname

        Glide.with(context)
            .load(_currentImg)
            .into(holder.Img)

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "App working", Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int {
        return category.size
    }

    class CategoryViewHolder(binding: HRvCategoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var name = binding.tvCategory
        var Img = binding.ivCategories
        var rootView = binding.root
    }

}