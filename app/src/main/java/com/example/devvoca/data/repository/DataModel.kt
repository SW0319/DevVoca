package com.example.devvoca.data.repository

import android.content.Context
import androidx.room.Room

object DataModel {

    lateinit var appDatabase: AppDatabase
    lateinit var wrongVocaDao: WrongVocaDao
    lateinit var favoriteVocaGroupDao: FavoriteVocaGroupDao
    lateinit var wordDao: WordDao
    lateinit var completeVocaDao: CompleteVocaDao

    const val localDB = "Room"
    const val serverDB = ""

    fun init(context: Context)
    {
        appDatabase = Room.databaseBuilder(context, AppDatabase::class.java,"vocaList").build()
        createLocalDao()
    }

    private fun createLocalDao()
    {
        completeVocaDao = appDatabase.completeVocaDao()
        favoriteVocaGroupDao = appDatabase.favoriteVocaGroupDao()
        wordDao = appDatabase.wordDao()
        wrongVocaDao = appDatabase.wrongVocaDao()
    }
}