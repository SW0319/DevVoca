package com.example.devvoca.domain.model

import com.google.gson.annotations.SerializedName

data class LoginToken(

    @SerializedName("token")
    val token : String,
    @SerializedName("email")
    val email : String,
    @SerializedName("name")
    val name : String,

    val message : String,
)