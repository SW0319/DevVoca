package com.example.devvoca.Repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WrongVoca")
data class WrongVoca(
    @PrimaryKey var w_no : Int,
    var v_no: Int,
    var wCount : Int,
    var lastSolve: String
)
