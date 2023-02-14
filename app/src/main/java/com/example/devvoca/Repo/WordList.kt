package com.example.devvoca.Repo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "WordList")
data class WordList(
    @PrimaryKey(autoGenerate = true) val v_no: Int = 0,
    val voca: String,
    val translate: String,
    val example: String,
    val devType: String,
)
