package com.jay.wallpaperapp.data.interfaces

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jay.wallpaperapp.data.dataClass.AddNew
import retrofit2.http.DELETE


@Dao
interface AddNewInterfaceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:AddNew):Long

    @Query("SELECT * from NewNote")
    fun getnotes(): LiveData<List<AddNew>>

    @DELETE
    fun deletenote(note:AddNew):Long

}