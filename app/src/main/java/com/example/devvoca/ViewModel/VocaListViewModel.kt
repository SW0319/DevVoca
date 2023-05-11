package com.example.devvoca.ViewModel

import com.example.devvoca.CustomList.ObservableArrayList
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.Model.DataModel
import com.example.devvoca.Model.RetrofitCon
import com.example.devvoca.Model.WordService
import com.example.devvoca.Repo.VocaList
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object VocaListViewModel : Callback<List<VocaList>>{

    lateinit var wordLists : ObservableArrayList<VocaList>
    //업데이트 삭제 선호
    lateinit var wordService: WordService

    fun init(wordlist : ObservableArrayList<VocaList>)
    {
        wordLists = wordlist
        wordService = RetrofitCon.getWordService()
        runBlocking(Dispatchers.IO) {
            DataModel.wordDao.removeAll()
            wordLists.clear()
            downloadVocaListFrom(DataModel.serverDB)
            }
    }

    suspend fun readAllVocaList(dbType: String)
    {
            when (dbType) {
                DataModel.localDB -> {

                    wordLists.addAll(DataModel.wordDao.getAll().apply { Log.e("test","사이즈 : ${size}") })
                }
                DataModel.serverDB -> {
                    //TODO : 백엔드 필요
                }
            }
    }

    suspend fun downloadVocaListFrom(type: String)  //서버로부터 단어 목록을 가져오는 함수
    {
        when (type)
        {
            DataModel.serverDB -> { //AWS Server

                if(wordLists.isEmpty()) //아무것도 없을 경우
                {
                    wordService.downloadAllVocaLists().enqueue(this)
                }
                else
                {
                    wordService.downloadNewVocaLists(lastVocaList = wordLists.last()).enqueue(this)
                }
            }
        }
    }

    //추가 기능

    fun addVocaListsToLocal(vocaList: List<VocaList>)
    {
        DataModel.wordDao.insertAll(*vocaList.toTypedArray().apply {
            forEach {
                Log.e("test","v_no 값 : ${it.v_no}")

            }
            wordLists.addAll(this)
        })
    }

    override fun onResponse(call: Call<List<VocaList>>, response: Response<List<VocaList>>) {
        Log.e("test","${response.body().toString()}")
        if(response.isSuccessful)
        {

         runBlocking(Dispatchers.IO) {
             addVocaListsToLocal(response.body()!!)
            }
        }
    }

    override fun onFailure(call: Call<List<VocaList>>, t: Throwable) {

    }
}