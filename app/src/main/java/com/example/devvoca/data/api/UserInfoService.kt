package com.example.devvoca.data.api

import com.example.devvoca.data.Entity.UserInfo
import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.domain.model.Badge
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserInfoService {

    @POST("/api/UserInfo/BadgeInfo")
    fun getLoginUserBadgeInfo(@Body loginInfo: UserInfo) : Response<List<Badge>>

    @POST("api/UserInfo/MemoryInfo")
    fun getLoginUserMemoryInfo(@Body loginInfo: UserInfo) : Response<UserMemory>

}