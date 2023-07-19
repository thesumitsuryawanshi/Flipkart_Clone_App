package com.example.flipkartcloneapp.View

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Home : AppCompatActivity() {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()



        setUpDrawerLayout(View(this))
        ToptoolbarItemCLicks()
    }



    private fun ToptoolbarItemCLicks() {
        binding.topAppToolBar.setOnMenuItemClickListener { menuitem ->
            when (menuitem.itemId) {

                R.id.mi_Cart -> {
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

    private fun setUpDrawerLayout(parent: View?) {

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.mainDrawerLayout,
            binding.topAppToolBar,
            R.string.app_name,
            R.string.app_name
        )

        binding.mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        binding.navDrawer.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mi_shareApp -> {
                    shareAppOffline()
                }
                R.id.mi_exit -> {
                    finish()
                    finishAffinity()
                }
                R.id.mi_about -> {
                    AlertDialog.Builder(this)
                        .setTitle(" -: Developer Info :- ")
                        .setMessage(

                            "Greetings!\n" +
                                    "\n" +
                                    "I am Sumit Suryawanshi, a dedicated Software Engineer with a passion for driving organizational and personal growth.\n" +
                                    "Currently pursuing a Computer Science Degree from Harvard University, I possess a strong academic foundation and a diverse skill set.\n" +
                                    "My expertise includes Android development, utilizing Kotlin, Ruby on Rails, and Reactjs. As a professional with experience in software engineering, I have contributed significantly to American Directories Operations & Computerized Systems (AMDOCS) as a Software Engineer (TBO analyst), maintaining and enhancing the existing codebase while actively contributing to pre-existing architecture designs.\n" +
                                    "My relentless curiosity to understand the core of everything allows me to approach problem-solving at a quantum level.\n" +
                                    "\n" +
                                    "In addition to my professional experience, I have explored my passion for Android development as a Freelancer, where I designed wireframes and developed Android applications tailored to specific user needs.\n" +
                                    "My educational journey includes a Bachelor of Computer Science from ATSS-CBSCA College and higher secondary education from Shri Fattechand Jain Junior College. I thrive on continuous learning, often seeking knowledge by Googling everything and leveraging GitHub for collaborative projects.\n" +
                                    "My problem-solving skills are complemented by an innate ability to figure out complexity and unravel challenging problems.\n" +
                                    "I am excited about future opportunities to contribute my skills and make a positive impact in the field of software engineering."
                        )
                        .setIcon(R.drawable.ic_fav_click)
                        .setPositiveButton("visit my Website")
                        { _, _ ->
                            CustomTabsIntent.Builder()
                                .build()
                                .launchUrl(this, Uri.parse("https://thesumitsuryawanshi.github.io"))
                        }
                        .setNegativeButton("Close") { dialog, _ -> dialog.dismiss() }
                        .create()
                        .show()
                }
            }
            true

        }
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

    private fun shareAppOffline() {
        val contentToShare = "Check out this amazing app! It has cool features and awesome content."

        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Share App")
        shareIntent.putExtra(Intent.EXTRA_TEXT, contentToShare)
        startActivity(Intent.createChooser(shareIntent, "Share via"))
    }

}