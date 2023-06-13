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
        Rv_BrandDeals()
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

        var name = listOf("offer", "offer", "offer", "offer", "offer","offer")
        val adapter = rv_BackToCityDealsAdapter(name)
        binding.rvBackToCity.adapter = adapter

        binding.rvBackToCity.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun Rv_BrandDeals() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer" )
        val adapter = rv_clothing_and_Shoes_adapter(name)
        binding.rvClothingAndShoes.adapter = adapter

        binding.rvClothingAndShoes.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun RV_Offers_SetUp() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rvOffersAdapter(name)
        binding.rvOffers.adapter = adapter
        binding.rvOffers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

    }

    private fun RV_Category_SetUp() {
        val name =listOf("Electronics", "Fasion", "Furniture", "Gifts", "Grosery", "Mobiles", "Toys")
        val imgList =listOf(R.drawable.c_electronics,R.drawable.c_fasion , R.drawable.c_furniture
            ,R.drawable.c_gifts,
            R.drawable.c_grosery , R.drawable.c_mobiles, R.drawable.c_toys)


        val adapter = rvCategoriesAdapter(name,imgList, requireContext() )
        binding.rvCategories.adapter = adapter
        binding.rvCategories.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }

    private fun AutoImageSlider() {

        val images = listOf(
            R.drawable.alia_bhat_banner,
            R.drawable.indian_people_banner,
            R.drawable.kohli_banner
        )

        sliderAdapter = SliderAdapter(images)
        val autoimgSlider = binding.autoImgSlider

        autoimgSlider.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR
        autoimgSlider.setSliderAdapter(sliderAdapter)
        autoimgSlider.scrollTimeInSec = 2
        autoimgSlider.isAutoCycle = true

        binding.autoImgSlider.startAutoCycle()

    }
}