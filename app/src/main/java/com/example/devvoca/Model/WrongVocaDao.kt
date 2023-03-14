package com.example.devvoca.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.devvoca.Repo.WrongVoca

@Dao
interface WrongVocaDao {

    @Insert
    fun insertData(wrongVoca: WrongVoca)

    @Update
    fun updateData(wrongVoca: WrongVoca)
}