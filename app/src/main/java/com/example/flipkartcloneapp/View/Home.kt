package com.example.flipkartcloneapp.View

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.ActivityHomeBinding
import com.example.flipkartcloneapp.View.fragments.HomeFrag
import com.google.android.material.snackbar.Snackbar

class Home : AppCompatActivity() {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
                    // TODO: check whether this trnaaction of fragment is working or not.
                    NavHostFragment.findNavController(HomeFrag())
                        .navigate(R.id.GlobalActionToCartFrag)
                }
                R.id.mi_notifications -> {
                    // TODO: check whether this trnaaction of fragment is working or not.
                    NavHostFragment.findNavController(HomeFrag())
                        .navigate(R.id.GlobalActionToNotificationFrag)
                }
                else -> {
                    Snackbar.make(binding.topAppToolBar, "Notifications", Snackbar.LENGTH_LONG)
                        .show()
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