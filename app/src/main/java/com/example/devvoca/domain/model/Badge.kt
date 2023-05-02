package com.example.devvoca.domain.model

data class Badge(
    var b_No : Int,     //뱃지의 경우 서버에서 특정 조건에 따라 데이터를 가지고 오며, 번호에 따른 이미지를 app에서는 이미 가지고 있다.
    var b_Name : String,
    var b_Description : String,
)
