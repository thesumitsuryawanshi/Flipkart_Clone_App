package com.example.flipkartcloneapp.View.Adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.HRvCategoriesBinding
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext

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
            val bundle = Bundle()
            bundle.putString("note", Gson().toJson(category))
            findNavController(it).navigate(R.id.GlobalActionTAllProductsFrag, bundle)
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