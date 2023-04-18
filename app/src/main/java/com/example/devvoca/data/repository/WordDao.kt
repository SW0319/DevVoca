package com.example.devvoca.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.devvoca.domain.model.VocaList

@Dao
interface WordDao {

    @Query("SELECT * FROM VocaList")
    fun getAll(): List<VocaList>

    @Insert
    fun insert(wordList: VocaList)

    @Insert
    fun insertAll(vararg wordList: VocaList)

    @Query("DELETE FROM VocaList")
    fun removeAll()
}