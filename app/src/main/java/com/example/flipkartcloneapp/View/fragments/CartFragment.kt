package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Model.entities.cartItems
import com.example.flipkartcloneapp.View.Adapters.HomeFragAdapter.rv_cartItemsAdapter
import com.example.flipkartcloneapp.databinding.FragmentCartBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson

class CartFragment : Fragment() {

    private var cartData: cartItems? = null
    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        assignDataTOUi()
    }

    private fun assignDataTOUi() {

        val _data = arguments?.getString("newCartItem")
        cartData = Gson().fromJson(_data, cartItems::class.java)

        Snackbar.make(binding.root, "Item Added to Cart", Snackbar.LENGTH_LONG).show()
        Log.d("mytag", "$cartData")

        val adapter = rv_cartItemsAdapter(cartData as cartItems)
        binding.rvCartBinding.adapter = adapter

        binding.rvCartBinding.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }
}