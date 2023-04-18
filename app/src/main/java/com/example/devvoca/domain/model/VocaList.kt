package com.example.devvoca.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "VocaList")
data class VocaList(
    @PrimaryKey(autoGenerate = false) val v_no: Int,

    @SerializedName("vocaname")
    val vocaname: String,
    @SerializedName("howtoRead")
    val howtoRead : String,
    val translate: String,
    val example: String,
    val exampleTranslate: String,
    @SerializedName("dev_type")
    val devType: Int,
)
