package com.example.devvoca.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteVoca(
    @PrimaryKey var f_no : Int,
    var v_no : Int,
    var prefer: Int,
    var addDate: String,
    var tag:String = "default",

)
