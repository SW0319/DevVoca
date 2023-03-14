package com.example.devvoca.Repo

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.devvoca.Model.CompleteVocaDao
import com.example.devvoca.Model.WordDao

@Database(entities = [VocaList::class, CompleteVoca::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun wordDao(): WordDao
    abstract fun completeVocaDao(): CompleteVocaDao
}