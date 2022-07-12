package com.example.flipkartcloneapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Adapters.*
import com.example.flipkartcloneapp.databinding.ActivityHomeBinding

class
Home : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportActionBar()?.hide()

        AutoImageSlider()
        RV_Category_SetUp()
        RV_Offers_SetUp()
        RV_BackToCityDealsSetUp()
        Rv_ClothingAndShoesSetUp()
        RV_MoreItemsSetUp()

    }


    private fun RV_MoreItemsSetUp() {
        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rv_moreItemsAdapter(name)
        binding.rvMoreItems.adapter = adapter

        binding.rvMoreItems.layoutManager =
            GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)


    }

    private fun RV_BackToCityDealsSetUp() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rv_BackToCityDealsAdapter(name)
        binding.rvBackToCity.adapter = adapter

        binding.rvBackToCity.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun Rv_ClothingAndShoesSetUp() {

        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rv_clothing_and_Shoes_adapter(name)
        binding.rvClothingAndShoes.adapter = adapter

        binding.rvClothingAndShoes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun RV_Offers_SetUp() {


        var name = listOf("offer", "offer", "offer", "offer", "offer", "offer", "offer", "offer")
        val adapter = rvOffersAdapter(name)
        binding.rvOffers.adapter = adapter

        binding.rvOffers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


    }

    private fun RV_Category_SetUp() {
        var name = listOf("temp", "temp", "temp", "temp", "temp", "temp", "temp", "temp")
        val adapter = rvCategoriesAdapter(name)
        binding.rvCategories.adapter = adapter

        binding.rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    private fun AutoImageSlider() {
        var images = listOf(R.drawable.img1, R.drawable.img2, R.drawable.img3)
        var adapter = ImgSliderViewPagerAdapter(images)

        binding.vpViewpager.adapter = adapter
    }

}