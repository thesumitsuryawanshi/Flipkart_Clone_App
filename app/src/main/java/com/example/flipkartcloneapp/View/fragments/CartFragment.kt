package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Model.entities.cartItems
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.HomeFragAdapter.rv_cartItemsAdapter
import com.example.flipkartcloneapp.databinding.FragmentCartBinding

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
//
//        val _data = arguments?.getString("newCartItem")
//        cartData = Gson().fromJson(_data, cartItems::class.java)
//
//        Snackbar.make(binding.root, "Item Added to Cart", Snackbar.LENGTH_LONG).show()
//        Log.d("mytag", "$cartData")

//        val adapter = rv_cartItemsAdapter(cartData as cartItems)
//        binding.rvCartBinding.adapter = adapter
//
//        binding.rvCartBinding.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        val NotificaitionList = listOf(
            "Order Placed Successfully ❤️",
            "Comfirmation pending \uD83E\uDD14 \uD83D\uDEEB ",
            "Order \uD83D\uDCE6  Arriving \n at your door\uD83D\uDEAA in 10 min.",
            "Notification4",
            "Notification5",
            "Notification6",
            "Notification7",
            "Notification8",
            "Notification9",
            "Notification10",
        )

        val NotificationimgList = listOf(
            R.drawable.ic_baseline_favorite_24,
            R.drawable.ic_question,
            R.drawable.ic_face,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert,
            R.drawable.ic_alert
        )

        val NotificaitiontimeList = listOf(
            "⌚ 9:12 am",
            "⌚ 3:02 pm",
            "⌚ 6:12 pm",
            "⌚ 9:01 pm",
            "⌚ 7:12 am",
            "⌚ 9:12 am",
            "⌚ 6:12 pm",
            "⌚ 9:01 pm",
            "⌚ 7:12 am",
            "⌚ 9:12 am"
        )


        val adapter = rv_cartItemsAdapter(cartData as cartItems)
        binding.rvCartBinding.adapter = adapter

        binding.rvCartBinding.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}