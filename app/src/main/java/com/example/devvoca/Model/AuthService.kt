package com.example.devvoca.Model

import com.example.devvoca.Repo.LoginToken
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService { //인증 서비스

    /*
    @Body Annotation을 통하여 Body에 넣을 데이터를 지정할 수 있다.
     */
    @POST("api/auth/{platform}") //{}로 묶으면 변수값을 사용 할 수 있다.
    fun loginAuthToBackEnd(@Path("platform") platform: String, @Body idTokenString : LoginToken) : Call<LoginToken>

}