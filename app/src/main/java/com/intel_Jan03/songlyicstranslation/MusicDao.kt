package com.intel_Jan03.songlyicstranslation

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicDao {
    @Query("SELECT * FROM music")
    fun getMusic(): List<Music>

//    @Query("SELECT lyics FROM music")
//    fun loadLyics(): List< Music>

    @Insert
    fun insertMusic(vararg music: Music)

    @Delete
    fun deleteMusic(music: Music)
}