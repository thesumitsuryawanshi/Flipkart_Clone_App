package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragViewProductBinding

class showProductFrag(private var Productdetails: ProductList) :
    Fragment(R.layout.frag_view_product) {

    lateinit var binding: FragViewProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragViewProductBinding.inflate(inflater, container, false)

        assignDataToUI(Productdetails)
        return binding.root
    }

    private fun assignDataToUI(Productdetails: ProductList) {

        Log.d("mytag", "data in showProductFrag")
        Glide.with(this)
            .load(Productdetails)
            .into(binding.ivProductImage)

    }


}