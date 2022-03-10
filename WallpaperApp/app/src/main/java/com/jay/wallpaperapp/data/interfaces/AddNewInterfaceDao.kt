package com.jay.wallpaperapp.data.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jay.wallpaperapp.data.dataClass.AddNew


@Dao
interface AddNewInterfaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:AddNew):Long

    @Query("SELECT * from NewNote")
    fun getnotes(): LiveData<List<AddNew>>

    @Delete
    suspend fun deletenote(note:AddNew)

}