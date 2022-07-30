package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flipkartcloneapp.databinding.FragmentCartBinding

class CartFragment : Fragment() {


    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

}