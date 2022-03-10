package com.jay.wallpaperapp.presentation.ui.adapters

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.data.dataClass.AddNew
import com.jay.wallpaperapp.data.database.NoteDatabase
import com.jay.wallpaperapp.data.interfaces.AddNewInterfaceDao
import com.jay.wallpaperapp.data.repository.Notesrepository
import com.jay.wallpaperapp.databinding.ImageslayoutBinding
import com.jay.wallpaperapp.presentation.ui.activity.MainActivity
import com.jay.wallpaperapp.presentation.ui.viewmodel.ImageViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ImageAdapter(val context: Context):RecyclerView.Adapter<ImageAdapter.NotesViewHolder>() {

    var noteList = ArrayList<AddNew>()

    inner class NotesViewHolder(itemview: ImageslayoutBinding ): RecyclerView.ViewHolder(itemview.root){

        var a = false
        var title = itemview.title
        var description = itemview.des
        var del = itemview.addfav

        init {
            itemview.root.setOnClickListener{
                noteList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
//                deletenote(adapterPosition,context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(ImageslayoutBinding.bind(LayoutInflater.from(parent.context).inflate(R.layout.imageslayout,parent,false)))
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val currentPosition = noteList[position]

        holder.title.text = currentPosition.title
        holder.description.text = currentPosition.description
        if (holder.del.isChecked){
           suspend { deletenote(currentPosition.id, context)}
        }

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun addnote(note: AddNew){

        this.noteList.add(note)
        this.notifyItemInserted(this.noteList.size-1)

    }

    fun deletenote(position: Int, context: Context){
        val note = noteList[position]
        ImageViewModel(Notesrepository(NoteDatabase.invoke(context))).deleteNote(note)
    }
    fun getId(): Int{
        return this.noteList.size
    }

}