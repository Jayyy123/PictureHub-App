package com.jay.wallpaperapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jay.wallpaperapp.data.dataClass.AddNew
import com.jay.wallpaperapp.data.interfaces.AddNewInterfaceDao

@Database(entities = [AddNew::class], version = 1)
abstract class NoteDatabase:RoomDatabase() {


    abstract fun getAddNewDao() : AddNewInterfaceDao

    companion object{

        @Volatile
        private var instance : NoteDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {

            instance ?: createDatabase(context).also{ instance=it}

        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            NoteDatabase::class.java,
            "noteDatabase.db"
        ).build()

    }

}