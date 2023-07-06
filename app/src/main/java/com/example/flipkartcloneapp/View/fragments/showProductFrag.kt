package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.Model.entities.cartItems
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragViewProductBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class

showProductFrag() :
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


        binding.fbFavouriteBtn.setOnClickListener {

            findNavController().navigate(R.id.action_showProductFrag_to_frag_Favourite)
            Snackbar.make(binding.root, "fav btn clicked ", Snackbar.LENGTH_SHORT).show()
        }


    }

    private fun assignDataToUI() {

        val _data = arguments?.getString("note")

        var cartItem: cartItems?

        if (_data != null) {
            ProductData = Gson().fromJson(_data, ProductList::class.java)
            ProductData.let {
                binding.tvActualPrice.text = it?.pActualPrice
                binding.tvProductName.text = it?.pName
                binding.tvCustomerRatingsCount.text = it?.pRatingCount
                binding.tvRatingsOnProduct.text = it?.pRatings
                binding.tvPrice.text = it?.pPrice
                binding.tvDiscountOnProductPrice.text = it?.pBankDiscount

                Glide.with(this)
                    .load(it?.pImgUrl)
                    .into(binding.ivProductImage)


                cartItem = cartItems(
                    it?.pTitle.toString(),
                    it?.pImgUrl.toString(),
                    it?.pPrice.toString()
                )
                addToCartData(cartItem!!)
            }


        } else {
            Snackbar.make(binding.root, "Something went wrong ", Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun addToCartData(cartItem: cartItems) {

        binding.btnAddToCart.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("newCartItem", Gson().toJson(cartItem))
            findNavController().navigate(R.id.action_showProductFrag_to_cartFrag, bundle)

        }
    }
}