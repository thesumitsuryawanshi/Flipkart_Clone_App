package com.example.flipkartcloneapp.View

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabsIntent
import androidx.navigation.Navigation
import com.example.flipkartcloneapp.R
import com.example.flipkartcloneapp.databinding.ActivityHomeBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Home : AppCompatActivity() {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityHomeBinding
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        supportActionBar?.hide()
        setContentView(binding.root)


        mAuth = FirebaseAuth.getInstance()


        ToptoolbarItemCLicks()
        setUpDrawerLayout()
    }

    private fun ToptoolbarItemCLicks() {
        binding.topAppToolBar.setOnMenuItemClickListener { menuitem ->
            when (menuitem.itemId) {

                R.id.mi_Cart -> {
                    Snackbar.make(binding.root, " Cart frag  ", Snackbar.LENGTH_LONG).show()
                    Navigation.findNavController(binding.navHostFragment)
                        .navigate(R.id.action_homeFrag_to_cartFrag)
                }
                R.id.mi_notifications -> {
                    Navigation.findNavController(binding.navHostFragment)
                        .navigate(R.id.GlobalActionToNotificationFrag)
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

        binding.navDrawer.setNavigationItemSelectedListener {


            when (it.itemId) {
                R.id.mi_favourite -> {
                    Toast.makeText(this, "Fav ", Toast.LENGTH_SHORT).show()
//                    findNavController(binding.root.id).navigate(R.id.action_homeFrag_to_showProductFrag)
//                    Snackbar.make(binding.root, "fav btn clicked ", Snackbar.LENGTH_SHORT).show()
                }

                R.id.mi_about -> {

                    AlertDialog.Builder(this)
                        .setTitle(" -: Developer Info :- ")

                        .setMessage(
                            "  \n     A Software Engineer based in \n India \uD83C\uDDEE\uD83C\uDDF3." +
                                    "  \n\n     An extremely passionated guy who is always pushing his boundaries\uD83D\uDE80.\n" +
                                    "        " +
                                    "  an adaptable team player with huge Team-Spirit ⚡. " +
                                    " \n Thriving in collaborative environments " +
                                    "  & excelling myself in independent projects as well. " +
                                    "  \n \n      My commitment \uD83E\uDD1D to Quality work with mindset of constantly learner \uD83D\uDCC6 will definately bring massive value to the " +
                                    "  organization for growth & this makes me Unique asset for Company \uD83C\uDFE2." +
                                    "  \n\n\n"
                        )
                        .setIcon(R.drawable.studboy)
                        .setPositiveButton("visit my Website \uD83C\uDF10 ")
                        { _, _ ->
                            CustomTabsIntent.Builder()
                                .build()
                                .launchUrl(
                                    this,
                                    Uri.parse("https://thesumitsuryawanshi.github.io ")
                                )
                        }
                        .setNeutralButton("CheckOut my CV \uD83D\uDCDD ") { _, _ ->
                            CustomTabsIntent.Builder()
                                .build()
                                .launchUrl(this, Uri.parse("https://flowcv.com/resume/k842ss0bhn "))
                        }

                        .setNegativeButton("Close ❌") { dialog, _ -> dialog.dismiss() }
                        .create()
                        .show()
                }

                R.id.mi_shareApp -> {
                    Toast.makeText(this, "Share App", Toast.LENGTH_SHORT).show()

                    val appPackageName = packageName
                    val sharingIntent = Intent(Intent.ACTION_SEND)
                    sharingIntent.type = "text/plain"
                    sharingIntent.putExtra(
                        Intent.EXTRA_TEXT,
                        "Check out this amazing app: https://play.google.com/store/apps/details?id=$appPackageName"
                    )
                    startActivity(Intent.createChooser(sharingIntent, "Share via"))
                }

                R.id.mi_logout -> {


                    Snackbar.make(binding.root, "Sign Out Successful.", Snackbar.LENGTH_SHORT)
                        .show()
                    mAuth.signOut()

                    val homeIntent = Intent(Intent.ACTION_MAIN)
                    homeIntent.addCategory(Intent.CATEGORY_HOME)
                    homeIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                    startActivity(homeIntent)
                    finish()


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

}