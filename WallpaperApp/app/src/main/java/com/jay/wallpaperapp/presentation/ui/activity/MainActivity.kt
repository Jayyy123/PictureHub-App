package com.jay.wallpaperapp.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewbinding.ViewBinding
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.databinding.ActivityMainBinding
import com.jay.wallpaperapp.presentation.ui.fragments.FavouritesFragment
import com.jay.wallpaperapp.presentation.ui.fragments.ImageFragment
import com.jay.wallpaperapp.presentation.ui.fragments.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var  navontroller: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val search = SearchFragment()
        val favourites = FavouritesFragment()
        val images = ImageFragment()

        supportActionBar?.hide()
//        setfragment(images)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment

        navontroller = navHostFragment.navController


        binding.bnv.setupWithNavController(navontroller)

//        binding.bnv.setupWithNavController(binding.fragmentContainerView.findNavController())

//        binding.bnv.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.search_images_icon -> setfragment(search)
//                R.id.images_icon -> setfragment(images)
//                R.id.favourites_icon -> setfragment(favourites)
//
//            }
//            true
////
////        }
//        }

    }

//    private fun setfragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
//        replace(R.id.fragmentContainerView, fragment)
//        commit()
//    }
}