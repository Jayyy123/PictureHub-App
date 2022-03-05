package com.jay.wallpaperapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.databinding.FragmentAddBinding
import com.jay.wallpaperapp.presentation.ui.activity.MainActivity
import com.jay.wallpaperapp.presentation.ui.viewmodel.ImageViewModel


class AddFragment : Fragment(R.layout.fragment_add) {


    lateinit var binding: FragmentAddBinding
    lateinit var iVM: ImageViewModel
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddBinding.bind(view)

        val title = binding.newtitle.text.toString()
        val description = binding.newdes.text.toString()

        iVM = (activity as MainActivity).iVM


        var nav = (activity as MainActivity)
        navController = (activity as MainActivity).navontroller


        binding.addto.setOnClickListener {
            val note = iVM.addNote(0,title,description)
            iVM.insertNote(note)

            navController.navigate(R.id.action_addFragment_to_imageFragment)

        }

    }

}