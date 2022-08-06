package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Adapters.*
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView

class HomeFrag : Fragment(R.layout.fragment_home) {

    lateinit var binding: FragmentHomeBinding
    lateinit var sliderAdapter: SliderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)


        checkGooglelogin()
        AutoImageSlider()
        RV_Category_SetUp()
        RV_Offers_SetUp()
        RV_BackToCityDealsSetUp()
        Rv_ClothingAndShoesSetUp()
        RV_MoreItemsSetUp()


        return binding.root
    }

    private fun checkGooglelogin() {

    }


    private fun RV_MoreItemsSetUp() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rv_moreItemsAdapter(name)
        binding.rvMoreItems.adapter = adapter

        binding.rvMoreItems.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)

    }

    private fun RV_BackToCityDealsSetUp() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rv_BackToCityDealsAdapter(name)
        binding.rvBackToCity.adapter = adapter

        binding.rvBackToCity.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun Rv_ClothingAndShoesSetUp() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rv_clothing_and_Shoes_adapter(name)
        binding.rvClothingAndShoes.adapter = adapter

        binding.rvClothingAndShoes.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun RV_Offers_SetUp() {


        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rvOffersAdapter(name)
        binding.rvOffers.adapter = adapter

        binding.rvOffers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


    }

    private fun RV_Category_SetUp() {
        var name = listOf("temp", "temp", "temp", "temp", "temp", "temp", "temp", "temp")
        val adapter = rvCategoriesAdapter(name)
        binding.rvCategories.adapter = adapter

        binding.rvCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun AutoImageSlider() {

        val images = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)

        sliderAdapter = SliderAdapter(images)
        val autoimgSlider = binding.autoImgSlider

        autoimgSlider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        autoimgSlider.setSliderAdapter(sliderAdapter)
        autoimgSlider.scrollTimeInSec = 2
        autoimgSlider.isAutoCycle = true

        binding.autoImgSlider.startAutoCycle()

    }

}