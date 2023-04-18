package com.example.devvoca.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.devvoca.domain.model.FavoriteVoca

@Dao
interface FavoriteVocaDao {

    @Insert
    fun insertData(favoriteVoca: FavoriteVoca)

    @Update
    fun updateData(favoriteVoca: FavoriteVoca)
}