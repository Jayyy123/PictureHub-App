package com.jay.wallpaperapp.presentation.ui.adapters

import android.media.Image
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jay.wallpaperapp.R
import com.jay.wallpaperapp.data.dataClass.AddNew
import com.jay.wallpaperapp.databinding.ImageslayoutBinding

class ImageAdapter():RecyclerView.Adapter<ImageAdapter.NotesViewHolder>() {

    var noteList = ArrayList<AddNew>()

    inner class NotesViewHolder(val itemview: ImageslayoutBinding ): RecyclerView.ViewHolder(itemview.root){

        var a = false
        var title = itemview.title
        var description = itemview.des
        var del = itemview.addfav

        init {
            itemview.root.setOnClickListener{
                noteList.removeAt(adapterPosition)
                ImageAdapter().notifyItemRemoved(adapterPosition)
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
            deletenote(currentPosition.id)
        }

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun addnote(note: AddNew){

        this.noteList.add(note)
        this.notifyItemInserted(this.noteList.size-1)

    }

    fun deletenote(position: Int){
        ImageAdapter().noteList.removeAt(position)
        ImageAdapter().notifyItemRemoved(position)
    }
    fun getId(): Int{
        return this.noteList.size
    }

}