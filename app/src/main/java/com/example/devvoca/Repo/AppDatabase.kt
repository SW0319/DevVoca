package com.example.devvoca.Repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.devvoca.Model.WordDao

@Database(entities = [WordList::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun wordDao(): WordDao
}