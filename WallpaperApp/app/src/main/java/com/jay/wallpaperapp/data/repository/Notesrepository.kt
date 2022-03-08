package com.jay.wallpaperapp.data.repository

import com.jay.wallpaperapp.data.dataClass.AddNew
import com.jay.wallpaperapp.data.database.NoteDatabase
import com.jay.wallpaperapp.data.interfaces.AddNewInterfaceDao

class Notesrepository(val anid:NoteDatabase) {

    fun getAllNotes() = anid.getAddNewDao().getnotes()

    suspend fun insertNote(note:AddNew) = anid.getAddNewDao().insert(note)

    suspend fun deleteNote(note: AddNew) = anid.getAddNewDao().deletenote(note)

}