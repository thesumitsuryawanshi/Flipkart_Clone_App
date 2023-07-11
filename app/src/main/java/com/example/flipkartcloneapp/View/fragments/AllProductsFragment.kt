package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.rv_AllItemsAdapter
import com.example.flipkartcloneapp.databinding.FragmentAllProductsBinding
import com.google.android.material.snackbar.Snackbar

class AllProductsFragment : Fragment(), rv_AllItemsAdapter.ItemsCLickedFromAllProducts {


    lateinit var binding: FragmentAllProductsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAllProductsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        AllProductsTempAdapterSetup()

    }

    private fun AllProductsTempAdapterSetup() {

        val name =
            listOf(
                "Electronics",
                "Fasion",
                "Furniture",
                "Gifts",
                "Grosery",
                "Mobiles"
            )
        val imgList = listOf(
            R.drawable.c_electronics,
            R.drawable.c_fasion,
            R.drawable.c_furniture,
            R.drawable.c_gifts,
            R.drawable.c_grosery,
            R.drawable.c_mobiles,
        )


        val adapter = rv_AllItemsAdapter(name, imgList, this)
        binding.rvAllItemsList.adapter = adapter
        binding.rvAllItemsList.layoutManager =
            GridLayoutManager(requireContext(),2, GridLayoutManager.VERTICAL, false)

    }

    override fun ClickedItemFromAllProducts(item: String) {

        Snackbar.make(binding.root, "this goes to ShowProductFrag ", Snackbar.LENGTH_SHORT).show()

//        val bundle = Bundle()
//        bundle.putString("note", Gson().toJson(item))
//        findNavController().navigate(R.id.action_homeFrag_to_showProductFrag, bundle)

    }


}

