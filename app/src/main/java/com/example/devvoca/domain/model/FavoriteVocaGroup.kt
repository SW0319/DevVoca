package com.example.devvoca.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteVocaGroup(
    @PrimaryKey
    val group_No : Int,
    val favoriteGroupName:String,
    val favoriteVocaListArray : String,

)
