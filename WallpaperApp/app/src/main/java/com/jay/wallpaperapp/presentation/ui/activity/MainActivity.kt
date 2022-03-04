package com.jay.wallpaperapp.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.fragment.app.Fragment
import androidx.navigation.NavController

import androidx.navigation.ui.AppBarConfiguration

import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.databinding.ActivityMainBinding
import com.jay.wallpaperapp.presentation.ui.fragments.FavouritesFragment
import com.jay.wallpaperapp.presentation.ui.fragments.ImageFragment
import com.jay.wallpaperapp.presentation.ui.fragments.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var  navontroller: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var  toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val search = SearchFragment()
        val favourites = FavouritesFragment()
        val images = ImageFragment()

//        supportActionBar?.hide()

        setfragment(images)

        setSupportActionBar(binding.tb)

//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//
//        navontroller = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.imageFragment,R.id.favouritesFragment,R.id.searchFragment))
//
//        setupActionBarWithNavController(navontroller,appBarConfiguration)

//        binding.bnv.setupWithNavController(findNavController(R.id.fl))

//        binding.bnv.setupWithNavController(binding.fragmentContainerView.findNavController())

        binding.bnv.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.search_images_icon -> setfragment(search)
                R.id.images_icon -> setfragment(images)
                R.id.favourites_icon -> setfragment(favourites)
            }
            true
        }
        toggle = ActionBarDrawerToggle(this, binding.dl,R.string.open,R.string.close)
        binding.dl.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



    private fun setfragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fragmentContainerView, fragment)
        commit()
    }
}