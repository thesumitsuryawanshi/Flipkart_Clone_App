package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.rv_AllItemsAdapter
import com.example.flipkartcloneapp.View.Adapters.rv_moreItemsAdapter
import com.example.flipkartcloneapp.ViewModels.MainViewModel
import com.example.flipkartcloneapp.databinding.FragmentAllProductsBinding
import com.google.android.material.snackbar.Snackbar

class AllProductsFragment : Fragment() {


    lateinit var binding: FragmentAllProductsBinding
    private lateinit var mainViewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllProductsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

//        AllProductsTempAdapterSetup()
          assigningValues()
    }

    private fun assigningValues() {

        //--------------------------------------------------------------------------------------------------------------------

        arguments?.getString("category_keyElectronics")?.apply {
            mainViewModel.CEList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

        arguments?.getString("category_keyFasion")?.apply {
            mainViewModel.CFList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

        arguments?.getString("category_keyFurniture")?.apply {
            mainViewModel.CFurList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

        arguments?.getString("category_keyGrosery")?.apply {
            mainViewModel.CGList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

        arguments?.getString("category_keyMobiles")?.apply {
            mainViewModel.CMList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

        arguments?.getString("category_keyToys")?.apply {
            mainViewModel.CTList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

        //--------------------------------------------------------------------------------------------------------------------

        arguments?.getString("offers_key")?.apply {
            mainViewModel.CEList.observe(viewLifecycleOwner) { newData ->


                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }
        arguments?.getString("btcDeals_key")?.apply {
            mainViewModel.CEList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }
        arguments?.getString("brandDeals_key")?.apply {
            mainViewModel.CEList.observe(viewLifecycleOwner) { newData ->
                // Handle the updated data here
                val adapter = rv_AllItemsAdapter(newData)
                binding.rvAllItemsList.adapter = adapter
                binding.rvAllItemsList.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
            }
        }

    }



//        if (_data != null) {
//            Snackbar.make(binding.root, "Data fetching success.\n \n $_data", Snackbar.LENGTH_SHORT)
//                .show()
//        } else {
//            Snackbar.make(binding.root, "Something went Wrong", Snackbar.LENGTH_SHORT).show()
//        }



//
//private fun AllProductsTempAdapterSetup() {
//
//    val name =
//        listOf(
//            "Electronics",
//            "Fasion",
//            "Furniture",
//            "Gifts",
//            "Grosery",
//            "Mobiles"
//        )
//    val imgList = listOf(
//        R.drawable.c_electronics,
//        R.drawable.c_fasion,
//        R.drawable.c_furniture,
//        R.drawable.c_gifts,
//        R.drawable.c_grosery,
//        R.drawable.c_mobiles,
//    )
//
////
////        val adapter = rv_AllItemsAdapter(name, imgList, this)
////        binding.rvAllItemsList.adapter = adapter
////        binding.rvAllItemsList.layoutManager =
////            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
//
//}

//override fun ClickedItemFromAllProducts(item: String) {
//
//    Snackbar.make(binding.root, "this goes to ShowProductFrag ", Snackbar.LENGTH_SHORT).show()
//
////        val bundle = Bundle()
////        bundle.putString("note", Gson().toJson(item))
////        findNavController().navigate(R.id.action_homeFrag_to_showProductFrag, bundle)
//
//}


}

