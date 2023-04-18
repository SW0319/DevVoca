package com.example.devvoca.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.devvoca.domain.model.WrongVoca

@Dao
interface WrongVocaDao {

    @Insert
    fun insertData(wrongVoca: WrongVoca)

    @Update
    fun updateData(wrongVoca: WrongVoca)
}