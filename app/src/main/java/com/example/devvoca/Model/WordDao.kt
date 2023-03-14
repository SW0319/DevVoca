package com.example.devvoca.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.devvoca.Repo.VocaList

@Dao
interface WordDao {

    @Query("SELECT * FROM VocaList")
    fun getAll(): List<VocaList>

    @Insert
    fun insert(wordList: VocaList)
}