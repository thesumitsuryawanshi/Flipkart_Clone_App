package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragViewProductBinding
import com.google.gson.Gson

class showProductFrag() :
    Fragment(R.layout.frag_view_product) {

    lateinit var binding: FragViewProductBinding
    private var ProductData: ProductList? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragViewProductBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assignDataToUI()
    }

    private fun assignDataToUI() {
        /// TODO: need to uadte the values in firebase firestiore database with emoji's
        /// TODO: need aesthetical touch on the showProductFragment
        val _data = arguments?.getString("note")
        if (_data != null) {
            ProductData = Gson().fromJson(_data, ProductList::class.java)
            ProductData.let {
                binding.tvActualPrice.text = it?.pActualPrice
                binding.tvProductName.text = it?.pName
                binding.tvCustomerRatingsCount.text = it?.pBankDiscount
                binding.tvRatingsOnProduct.text = it?.pRatings
                binding.tvPrice.text = it?.pPrice
                Glide.with(this)
                    .load(it?.pImgUrl)
                    .into(binding.ivProductImage)
            }
        } else {
        }
    }
}