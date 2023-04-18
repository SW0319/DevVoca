package com.example.devvoca.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CompleteVoca")
data class CompleteVoca(
    @PrimaryKey var c_no: Int,
    var v_no: Int,
    var cdate : String)
