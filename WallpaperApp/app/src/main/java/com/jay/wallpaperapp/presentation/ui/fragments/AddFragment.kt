package com.jay.wallpaperapp.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.databinding.FragmentAddBinding
import com.jay.wallpaperapp.presentation.ui.activity.MainActivity
import com.jay.wallpaperapp.presentation.ui.viewmodel.ImageViewModel
import com.jay.wallpaperapp.utils.constants.TAG


class AddFragment : Fragment(R.layout.fragment_add) {


    lateinit var binding: FragmentAddBinding
    lateinit var iVM: ImageViewModel
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddBinding.bind(view)

        val title = binding.newtitle.text.toString()
        val description = binding.newdes.text.toString()

        Log.d(TAG,"The title added is $title")

        iVM = (activity as MainActivity).iVM


        val nav = (activity as MainActivity)
        navController = (activity as MainActivity).navontroller


        binding.addto.setOnClickListener {

            if (title.isNotEmpty()) {
                Log.d(TAG,"The title added is $title")
                val note = iVM.addNote(0, title, description)
                iVM.insertNote(note)

                Log.d(TAG,"The note added to the database is $note")

//            navController.navigate(R.id.action_addFragment_to_imageFragment)
                Snackbar.make(view, "Your note has been saved", Snackbar.LENGTH_LONG).show()
                nav.supportFragmentManager.beginTransaction().replace(this.id, ImageFragment())
                    .commit()
            }else{
                Snackbar.make(view, "Please fill in a title", Snackbar.LENGTH_SHORT).show()
            }
        }

    }

}