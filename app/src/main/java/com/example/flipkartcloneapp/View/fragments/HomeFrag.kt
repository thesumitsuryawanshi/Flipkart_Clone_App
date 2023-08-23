package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flipkartcloneapp.Model.entities.ProductList
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.*
import com.example.flipkartcloneapp.ViewModels.MainViewModel
import com.example.flipkartcloneapp.databinding.FragmentHomeBinding
import com.google.gson.Gson
import com.smarteist.autoimageslider.SliderView


class HomeFrag : Fragment(R.layout.fragment_home), rv_moreItemsAdapter.ItemsCLicked {

    lateinit var binding: FragmentHomeBinding
    lateinit var sliderAdapter: SliderAdapter
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        checkGooglelogin()
        AutoImageSlider()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        RV_Category_SetUp()
        RV_MoreItemsSetUp()
        Rv_BrandDeals()
        RV_BackToCityDealsSetUp()
        RV_Offers_SetUp()
    }

    private fun checkGooglelogin() {

    }

    private fun RV_MoreItemsSetUp() {
        mainViewModel.pList.observe(viewLifecycleOwner) { newData ->
            // Handle the updated data here
            val adapter = rv_moreItemsAdapter(newData, this)
            binding.rvMoreItems.adapter = adapter
            binding.rvMoreItems.layoutManager =
                GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        }
    }

    private fun Rv_BrandDeals() {

        mainViewModel.BDList.observe(viewLifecycleOwner) { newData ->
            // Handle the updated data here
            val adapter = rv_brandDeals(newData, requireContext())
            binding.rvBrandDeals.adapter = adapter

            binding.rvBrandDeals.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun RV_BackToCityDealsSetUp() {

        mainViewModel.btcList.observe(viewLifecycleOwner) { newData ->
            // Handle the updated data here
            val adapter = rv_BackToCityDealsAdapter(newData, requireContext())
            binding.rvBackToCity.adapter = adapter

            binding.rvBackToCity.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun RV_Offers_SetUp() {
        mainViewModel.offerList.observe(viewLifecycleOwner) { newData ->
            // Handle the updated data here
            val adapter = rvOffersAdapter(newData, requireContext())
            binding.rvOffers.adapter = adapter

            binding.rvOffers.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun RV_Category_SetUp() {
        val name =  listOf("Electronics", "Fasion", "Furniture", "Grosery", "Mobiles", "Toys")
        val imgList = listOf(
            R.drawable.c_electronics,
            R.drawable.c_fasion,
            R.drawable.c_furniture,
            R.drawable.c_grosery,
            R.drawable.c_mobiles,
            R.drawable.c_toys
        )

        val adapter = rvCategoriesAdapter(name, imgList, requireContext())
        binding.rvCategories.adapter = adapter
        binding.rvCategories.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
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

    override fun ClickedItem(item: ProductList) {
        val bundle = Bundle()
        bundle.putString("MoreToLoveItem", Gson().toJson(item))
        findNavController().navigate(R.id.action_homeFrag_to_showProductFrag, bundle)
    }
}