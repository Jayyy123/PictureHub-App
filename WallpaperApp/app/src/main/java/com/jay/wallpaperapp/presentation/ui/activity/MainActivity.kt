package com.jay.wallpaperapp.presentation.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.data.database.NoteDatabase
import com.jay.wallpaperapp.data.repository.Notesrepository
import com.jay.wallpaperapp.databinding.ActivityMainBinding
import com.jay.wallpaperapp.presentation.ui.fragments.AddFragment
import com.jay.wallpaperapp.presentation.ui.fragments.ImageFragment
import com.jay.wallpaperapp.presentation.ui.viewmodel.ImageViewModel

class MainActivity : AppCompatActivity() {

    lateinit var  navontroller: NavController
    private lateinit var binding: ActivityMainBinding
//    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var  toggle:ActionBarDrawerToggle
    lateinit var iVM:ImageViewModel
//    private lateinit var imageAdapter: ImageAdapter
//    private lateinit var search: SearchFragment
//    private lateinit var favourites: FavouritesFragment
    private lateinit var images: ImageFragment
    private lateinit var add: AddFragment

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iVM = ImageViewModel(Notesrepository(NoteDatabase.invoke(this)))


        images = ImageFragment()
        add = AddFragment()


//        supportActionBar?.hide()

//        setfragment(images)

        setSupportActionBar(binding.tb)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
//
        navontroller = navHostFragment.navController
//        appBarConfiguration = AppBarConfiguration(setOf(R.id.imageFragment,R.id.favouritesFragment,R.id.searchFragment))
//
//        setupActionBarWithNavController(navontroller,appBarConfiguration)

        binding.bnv.setupWithNavController(navontroller)

//        binding.bnv.setupWithNavController(binding.fragmentContainerView.findNavController())

//        binding.bnv.setOnItemSelectedListener {
//
//            when (it.itemId) {
//                R.id.search_images_icon -> setfragment(search)
//                R.id.images_icon -> setfragment(images)
//                R.id.favourites_icon -> setfragment(favourites)
//            }
//            true
//        }
        toggle = ActionBarDrawerToggle(this, binding.dl,R.string.open,R.string.close)
        binding.dl.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)



//        imageAdapter.addnote(iVM.pore)
//        imageAdapter.addnote(iVM.pore1)
//        imageAdapter.addnote(iVM.pore2)


        binding.fab.setOnClickListener {
            if (iVM.check == 1){
                setfragment(add)
                iVM.check = 0
            }else{
                add.binding.addto.setOnClickListener {
                    setfragment(images)
                }
            }
        }

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
//    private fun imageAdapter(){
//        images.binding.imagerecycler.layoutManager = LinearLayoutManager(this@MainActivity)
//        images.binding.imagerecycler.adapter = imageAdapter
//
//    }
}
