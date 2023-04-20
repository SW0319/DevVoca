package com.example.devvoca.data.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitCon {

    var retrofit: Retrofit
    var url = "https://test.devvoca.p-e.kr/"
    private var authService : AuthService
    private var vocaService : VocaService

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()

        authService = retrofit.create(AuthService::class.java)
        vocaService = retrofit.create(VocaService::class.java)
    }


    fun getAuthService(): AuthService {
        return authService
    }

    fun getVocaService() : VocaService {
        return vocaService
    }

}