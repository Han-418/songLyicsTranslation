package com.intel_Jan03.songlyicstranslation

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Music::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun musicDao(): MusicDao
}

object Mydb {
    @Volatile // 메인메모리에 올리는 역할
    private var instance: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            Room.databaseBuilder(
                context,
                AppDatabase::class.java, "songLyicsTranslation.db" // db 이름은 프로젝트이름.db
            ).build().also { instance = it }
        }
    }
}
// synchronized(this) 동시접근 제한

