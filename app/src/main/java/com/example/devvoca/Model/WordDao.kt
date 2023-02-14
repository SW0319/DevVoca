package com.example.devvoca.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.devvoca.Repo.WordList

@Dao
interface WordDao {

    @Query("SELECT * FROM WordList")
    fun getAll(): List<WordList>

    @Insert
    fun insert(wordList: WordList)
}