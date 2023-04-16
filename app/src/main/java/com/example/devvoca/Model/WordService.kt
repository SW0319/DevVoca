package com.example.devvoca.Model

import com.example.devvoca.Repo.LoginToken
import com.example.devvoca.Repo.VocaList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WordService {

    @POST("api/word/downloadLists")
    fun downloadNewVocaLists(@Body lastVocaList: VocaList?) : Call<List<VocaList>>

    @POST("api/word/downloadAllLists")
    fun downloadAllVocaLists() : Call<List<VocaList>>

    @POST("api/word/wordRanking")
    fun getWordRanking() : Call<List<VocaList>>
}