package com.example.flipkartcloneapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Model.entities.AllProducts
import com.example.flipkartcloneapp.View.Adapters.rvNotificationAdapters
import com.example.flipkartcloneapp.databinding.FragmentFavBinding
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson


class FavFrag : Fragment() {

    lateinit var binding: FragmentFavBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFavBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sendingDataToFavFragAdapter()
    }

    private fun sendingDataToFavFragAdapter() {

        Snackbar.make(binding.root,"currentItem in FavFrag" , Snackbar.LENGTH_SHORT ).show()


        val _currentItem = arguments?.getString("currentItem")


        val data = Gson().fromJson(_currentItem, AllProducts::class.java)

//        val adapter = rvNotificationAdapters(name, imgList, requireContext())
//        binding.rvFavProductList.adapter = adapter
//        binding.rvFavProductList.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//



    }
}


