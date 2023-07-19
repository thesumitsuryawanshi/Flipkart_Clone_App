package com.example.flipkartcloneapp.View

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewpager2.widget.ViewPager2
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.View.Adapters.ViewPagerAdapter
import com.example.flipkartcloneapp.View.fragments.Login
import com.example.flipkartcloneapp.View.fragments.SignUp
import com.example.flipkartcloneapp.databinding.ActivityMainBinding

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var mAuth: FirebaseAuth
    lateinit var tabLayout: TabLayout
    lateinit var viewpager: ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setTheme(R.style.Theme_FlipkartCloneApp)

        binding = ActivityMainBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()



        setContentView(binding.root)

        if (!checkInternetConnection(this)) {
            Toast.makeText(this, "Need Internet connection", Toast.LENGTH_SHORT).show()
        }

        CheckGoogleSignIn()
        viewPagerInit()
    }

    private fun checkInternetConnection(context: Context): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {

                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
                    return true

                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {

                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
                    return true

                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {

                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
                    return true

                }
            }
        }
        return false
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