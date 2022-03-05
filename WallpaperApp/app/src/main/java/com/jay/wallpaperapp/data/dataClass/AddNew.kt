package com.jay.wallpaperapp.data.dataClass

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NewNote")
data class AddNew(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val title: String,
    val description: String,
)

data class AddFav(
    val title: String,
    val description: String,
    val liked:Boolean
)
