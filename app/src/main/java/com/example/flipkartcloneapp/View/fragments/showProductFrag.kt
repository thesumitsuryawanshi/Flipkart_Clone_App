package com.example.flipkartcloneapp.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.FragViewProductBinding

class showProductFrag : Fragment(R.layout.frag_view_product) {

lateinit var binding:FragViewProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragViewProductBinding.inflate(inflater, container, false)


        fabclickevent()
        return binding.root
    }

    private fun fabclickevent() {
        binding.fbFavouriteBtn.setOnClickListener {
            Toast.makeText(requireContext(), " its working ", Toast.LENGTH_SHORT).show()


            binding.fbFavouriteBtn.setBackgroundResource(R.color.red)
        }
    }
}