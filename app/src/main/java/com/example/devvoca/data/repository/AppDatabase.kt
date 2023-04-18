package com.example.devvoca.data.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.devvoca.data.repository.CompleteVocaDao
import com.example.devvoca.data.repository.FavoriteVocaDao
import com.example.devvoca.data.repository.WordDao
import com.example.devvoca.data.repository.WrongVocaDao
import com.example.devvoca.domain.model.CompleteVoca
import com.example.devvoca.domain.model.FavoriteVoca
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.domain.model.WrongVoca

@Database(entities = [VocaList::class, CompleteVoca::class, FavoriteVoca::class, WrongVoca::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun wordDao(): WordDao
    abstract fun completeVocaDao(): CompleteVocaDao
    abstract fun favoriteVocaDao() : FavoriteVocaDao
    abstract fun wrongVocaDao() : WrongVocaDao
}