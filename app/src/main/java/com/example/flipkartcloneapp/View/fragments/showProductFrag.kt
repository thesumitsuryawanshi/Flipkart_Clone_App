package com.example.flipkartcloneapp.View.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.AllProducts
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragViewProductBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class showProductFrag() :
    Fragment(R.layout.frag_view_product) {

    lateinit var binding: FragViewProductBinding
    private var ProductData: ProductList? = null
    private var currentItem: AllProducts? = null

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

    @SuppressLint("ResourceAsColor")
    private fun assignDataToUI() {

        val _data = arguments?.getString("MoreToLoveItem")
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

        val _currentItem = arguments?.getString("currentItem")
        if (_currentItem != null) {
            view?.let {
                Snackbar.make(
                    it,
                    "currentItem in  ShowProductFrag ",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            currentItem = Gson().fromJson(_currentItem, AllProducts::class.java)
            currentItem.let {
                binding.tvPrice.text = it?.price
                binding.tvActualPrice.text = " "
                binding.tvDiscountOnProductPrice.text = "25% Discount"
                binding.tvProductName.text = it?.title
                Glide.with(this)
                    .load(it?.img)
                    .into(binding.ivProductImage)
            }
        } else {
        }

        binding.btnAddToCart.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("currentItemFromShowProductFragtoAddToCart", Gson().toJson(_currentItem))
            findNavController().navigate(R.id.action_global_cartFrag, bundle)
        }
        binding.fbFavouriteBtn.setOnClickListener {
            findNavController().navigate(R.id.action_global_FavFrag)
        }
        binding.btnIWantThis.setOnClickListener {
            findNavController().navigate(R.id.action_global_cartFrag)
        }
    }

}