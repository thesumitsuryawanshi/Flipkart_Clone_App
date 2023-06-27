package com.example.flipkartcloneapp.View

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.Navigation
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.ViewModels.MainViewModel
import com.example.flipkartcloneapp.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar

class Home : AppCompatActivity() {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityHomeBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setUpDrawerLayout()
        ToptoolbarItemCLicks()
    }

    private fun ToptoolbarItemCLicks() {
        binding.topAppToolBar.setOnMenuItemClickListener { menuitem ->
            when (menuitem.itemId) {

                R.id.mi_Cart -> {
                    // TODO:  Need to implement :  after clicking this toptoolbar cart icon CartFrag should show up.
                    Navigation.findNavController(binding.navHostFragment)
                        .navigate(R.id.action_global_cartFrag)
                    Snackbar.make(binding.root, " Cart frag  ", Snackbar.LENGTH_LONG)
                        .show()
                }
                R.id.mi_notifications -> {
                    Navigation.findNavController(binding.navHostFragment)
                        .navigate(R.id.GlobalActionToNotificationFrag)
                    Snackbar.make(binding.root, "notifications frag", Snackbar.LENGTH_LONG)
                        .show()
                }

                else -> {
                    Snackbar.make(
                        binding.root,
                        "top tool bar item click not working.",
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
            true
        }
    }

    private fun setUpDrawerLayout() {

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.mainDrawerLayout,
            binding.topAppToolBar,
            R.string.app_name,
            R.string.app_name
        )

        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_tool_bar, menu)
        return true
    }

}