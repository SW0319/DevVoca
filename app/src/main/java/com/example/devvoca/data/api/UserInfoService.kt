package com.example.devvoca.data.api

import com.example.devvoca.data.Entity.LoginInfo
import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.domain.model.Badge
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInfoService {

    @POST("/api/UserInfo/BadgeInfo")
    fun getLoginUserBadgeInfo(@Body loginInfo: LoginInfo) : Call<List<Badge>>

    @POST("api/UserInfo/MemoryInfo")
    fun getLoginUserMemoryInfo(@Body loginInfo: LoginInfo) : Call<UserMemory>

}