package com.example.devvoca.data.api

import com.example.devvoca.data.Entity.LoginInfo
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

object RetrofitCon {

    var retrofit: Retrofit
    var destinationUrl = "https://test.devvoca.p-e.kr/"
    private var authService : AuthService
    private var vocaService : VocaService
    private var userInfoService : UserInfoService
    private lateinit var loginInfo : LoginInfo

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(destinationUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

        authService = retrofit.create(AuthService::class.java)
        vocaService = retrofit.create(VocaService::class.java)
        userInfoService = retrofit.create(UserInfoService::class.java)
    }


    fun getAuthService(): AuthService {
        return authService
    }

    fun getVocaService() : VocaService {
        return vocaService
    }

    fun getUserInfoService() : UserInfoService {
        return userInfoService
    }

    fun setLoginInfoData(loginInfo: LoginInfo)
    {
        this.loginInfo = loginInfo
    }

    fun getLoginInfoData() : LoginInfo
    {
        return loginInfo
    }
}