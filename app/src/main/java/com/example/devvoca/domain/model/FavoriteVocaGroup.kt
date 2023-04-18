package com.example.devvoca.domain.model

import androidx.room.PrimaryKey

data class FavoriteVocaGroup(
    @PrimaryKey
    val group_No : Int,
    val favoriteGroupName:String,
)
