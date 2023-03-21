package com.example.devvoca.Repo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VocaList")
data class VocaList(
    @PrimaryKey(autoGenerate = true) val v_no: Int = 0,
    val voca: String,
    val vocaReading : String,
    val translate: String,
    val example: String,
    val devType: String,
)
