package com.intel_Jan03.songlyicstranslation

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Music(
    @PrimaryKey(autoGenerate = true) val uid: Int = 0,
    @ColumnInfo(name = "song") val song: String?,
    @ColumnInfo(name = "singer") val singer: String?,
    @ColumnInfo(name = "lyics") val lyics: String?
)