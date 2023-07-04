package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flipkartcloneapp.databinding.FragmentFragFavouriteBinding


class Frag_Favourite : Fragment() {

    lateinit var binding: FragmentFragFavouriteBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFragFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "arrived at Fav ", Toast.LENGTH_SHORT).show()

    }
}
