package com.jay.wallpaperapp.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.data.dataClass.AddNew
import com.jay.wallpaperapp.data.database.NoteDatabase
import com.jay.wallpaperapp.data.repository.Notesrepository
import com.jay.wallpaperapp.databinding.FragmentImageBinding
import com.jay.wallpaperapp.presentation.ui.activity.MainActivity
import com.jay.wallpaperapp.presentation.ui.adapters.ImageAdapter
import com.jay.wallpaperapp.presentation.ui.viewmodel.ImageViewModel
import com.jay.wallpaperapp.utils.constants


class ImageFragment : Fragment(R.layout.fragment_image) {

    lateinit var binding: FragmentImageBinding
    lateinit var imageAdapter: ImageAdapter
    lateinit var vm: ImageViewModel

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
//        imageAdapter = ImageAdapter()
//        imageAdapter
//        vm = (activity as MainActivity).iVM
//
//        vm.allNotes().observe(viewLifecycleOwner, Observer {
//            imageAdapter.noteList = it as ArrayList<AddNew>
//            Log.d(constants.TAG,"The database table values are $it")
//        })
//
//        return super.onCreateView(inflater, container, savedInstanceState)
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentImageBinding.bind(view)

        imageAdapter = ImageAdapter(this.requireActivity())
//        vm = ImageViewModel()

        imageAdapter

//        val pore = AddNew(1,"problem no dey finish","bruh")
//        val pore1 = AddNew(2,"problem don dey finish","bruther")
//        val pore2 = AddNew(3,"problem don finish","bruv")

        imageAdapter.getId()
        vm = (activity as MainActivity).iVM
        vm.allNotes().observe(viewLifecycleOwner, Observer {
            imageAdapter.noteList = it as ArrayList<AddNew>
            Log.d(constants.TAG,"The database table values are $it")
        })
//        vm = ImageViewModel(Notesrepository(NoteDatabase.invoke(activity as MainActivity)))
//        imageAdapter.noteList = vm.allNotes().observe()

        binding.imagerecycler.adapter = imageAdapter
        binding.imagerecycler.layoutManager = LinearLayoutManager(this.activity)

    }

//    override fun onResume() {
//        imageAdapter = ImageAdapter()
//        imageAdapter
//        vm = (activity as MainActivity).iVM
//        super.onResume()
//    }
//
//    override fun onStart() {
//        imageAdapter = ImageAdapter()
//        imageAdapter
//        vm = (activity as MainActivity).iVM
//        super.onStart()
//    }




}