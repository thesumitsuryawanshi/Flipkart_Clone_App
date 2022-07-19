package com.example.flipkartcloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.flipkartcloneapp.Adapters.ViewPagerAdapter
import com.example.flipkartcloneapp.databinding.ActivityMainBinding
import com.example.flipkartcloneapp.fragments.Login
import com.example.flipkartcloneapp.fragments.SignUp
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mAuth: FirebaseAuth
    lateinit var tabLayout: TabLayout
    lateinit var viewpager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSupportActionBar()?.hide()

        CheckGoogleSignIn()
        viewPagerInit()

    }

    private fun CheckGoogleSignIn() {
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        if (user != null) {
            val i = Intent(this, Home::class.java)
            startActivity(i)
        } else {
            Toast.makeText(this, "Please Sign in first.", Toast.LENGTH_SHORT).show()
        }

    }

    fun viewPagerInit() {


        tabLayout = binding.tlTabLayout
        viewpager = binding.vpViewpager

        val tabNamesArray = arrayListOf("Sign Up", "Sign in")
        val fragmentArray = arrayListOf(SignUp(), Login())
        val adapter = ViewPagerAdapter(fragmentArray, this)

        viewpager.adapter = adapter
        TabLayoutMediator(tabLayout, viewpager) { tab, position ->
            tab.text = tabNamesArray[position]
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })

    }

}