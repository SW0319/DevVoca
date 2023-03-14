package com.example.devvoca.Model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import com.example.devvoca.Repo.FavoriteVoca

@Dao
interface FavoriteVocaDao {

    @Insert
    fun insertData(favoriteVoca: FavoriteVoca)

    @Update
    fun updateData(favoriteVoca: FavoriteVoca)
}