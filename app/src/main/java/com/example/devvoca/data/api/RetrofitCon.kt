package com.example.devvoca.data.api

import com.example.devvoca.data.Entity.UserInfo
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object RetrofitCon {

    var retrofit: Retrofit
    var destinationUrl = "https://test.devvoca.p-e.kr/"
    private var authService : AuthService
    private var vocaService : VocaService
    private var userInfoService : UserInfoService
    private lateinit var loginInfo : UserInfo

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(destinationUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
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

    fun setLoginInfoData(loginInfo: UserInfo)
    {
        this.loginInfo = loginInfo
    }

    fun getLoginInfoData() : UserInfo
    {
        return loginInfo
    }

    fun getLoginInfoData_testData() : UserInfo
    {
        return UserInfo(userNo = 1, email = "tisit0319@naver.com", userID = "사용자명", userName = "wlgnsdks")
    }
}