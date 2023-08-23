package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.rvCartItemAdapters
import com.example.flipkartcloneapp.databinding.FragmentCartBinding
import com.google.android.material.snackbar.Snackbar

class CartFragment : Fragment() {

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

        ReceiveDataAndPassToAdapter()
    }

    private fun ReceiveDataAndPassToAdapter() {

        val icon = listOf(
            R.drawable.c_electronics,
            R.drawable.c_fasion,
            R.drawable.c_furniture,
            R.drawable.c_grosery,
            R.drawable.c_mobiles,
            R.drawable.c_toys,
            R.drawable.c_gifts
        )
        val names =
            listOf("Electronics", "Fasion", "Furniture", "Grosery", "Mobiles", "Toys", "Gifts")
        val prices = listOf(
            "₹ 2,999/-",
            "₹ 3,999/-",
            "₹ 1,999/-",
            "₹ 3,999/-",
            "₹ 2,999/-",
            "₹ 1,999/-",
            "₹ 1,999/-"
        )

        val adapter = rvCartItemAdapters(icon, names, prices, requireContext())
        binding.rvCartItems.adapter = adapter
        binding.rvCartItems.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }
}