package com.intel_Jan03.songlyicstranslation

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicDao {
    @Query("SELECT * FROM music")
    fun getAll(): List<Music>

    @Insert
    fun insert(vararg music: Music)

    @Delete
    fun delete(music: Music)
}