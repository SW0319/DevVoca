package com.example.devvoca.data.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.devvoca.domain.model.FavoriteVocaGroup

@Dao
interface FavoriteVocaGroupDao {

    @Insert
    fun insertData(favoriteVoca: FavoriteVocaGroup)

    @Update
    fun updateData(favoriteVoca: FavoriteVocaGroup)

    @Query("Select * from FavoriteVocaGroup")
    fun getAll() : List<FavoriteVocaGroup>
    @Query("Delete from FavoriteVocaGroup")
    fun removeAll()
}