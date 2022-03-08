package com.jay.wallpaperapp.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jay.wallpaperapp.data.dataClass.AddNew
import com.jay.wallpaperapp.data.repository.Notesrepository
import kotlinx.coroutines.launch

class ImageViewModel(val notesrepository: Notesrepository):ViewModel() {
    var check = 1

//    val pore = AddNew(1,"problem no dey finish","bruh")
//    val pore1 = AddNew(1,"problem don dey finish","bruther")
//    val pore2 = AddNew(1,"problem don finish","bruv")

    fun addNote(number:Int,title:String,description:String) = AddNew(number  ,title, description)


    fun allNotes() = notesrepository.getAllNotes()

    fun insertNote(note:AddNew) = viewModelScope.launch {  notesrepository.insertNote(note) }
    fun deleteNote(note:AddNew) = viewModelScope.launch {  notesrepository.deleteNote(note) }

}