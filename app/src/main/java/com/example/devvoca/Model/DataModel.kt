package com.example.devvoca.Model

import android.content.Context
import androidx.room.Room
import com.example.devvoca.Repo.AppDatabase

object DataModel {

    lateinit var appDatabase: AppDatabase
    lateinit var wrongVocaDao: WrongVocaDao
    lateinit var favoriteVocaDao: FavoriteVocaDao
    lateinit var wordDao: WordDao
    lateinit var completeVocaDao: CompleteVocaDao

    fun init(context: Context)
    {
        appDatabase = Room.databaseBuilder(context, AppDatabase::class.java,"vocaList").build()
        createLocalDao()
    }

    private fun createLocalDao()
    {
        completeVocaDao = appDatabase.completeVocaDao()
        favoriteVocaDao = appDatabase.favoriteVocaDao()
        wordDao = appDatabase.wordDao()
        wrongVocaDao = appDatabase.wrongVocaDao()
    }
}