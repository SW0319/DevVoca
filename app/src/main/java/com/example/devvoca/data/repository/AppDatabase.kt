package com.example.devvoca.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.devvoca.domain.model.*

@Database(entities = [VocaList::class, CompleteVoca::class, FavoriteVocaGroup::class, WrongVoca::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun wordDao(): WordDao
    abstract fun completeVocaDao(): CompleteVocaDao
    abstract fun favoriteVocaGroupDao() : FavoriteVocaGroupDao
    abstract fun wrongVocaDao() : WrongVocaDao
}