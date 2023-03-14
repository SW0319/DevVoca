package com.example.devvoca.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.devvoca.Repo.CompleteVoca

@Dao
interface CompleteVocaDao {

    @Query("select * from CompleteVoca")
    fun getAll() : List<CompleteVoca>

    @Insert
    fun insertData(completeVoca: CompleteVoca)

    @Update
    fun updateData(completeVoca: CompleteVoca)
}