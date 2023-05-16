package com.example.devvoca.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.devvoca.data.repository.DataModel
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.domain.usecase.VocaListFragmentUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VocaListViewModel : Callback<List<VocaList>> {

    val dataList = MutableLiveData<List<VocaList>>()

    val favoriteVocaGroupList = MutableLiveData<List<FavoriteVocaGroup>>().apply {
        value = listOf()
    }

    private var vocalistFragmentUseCase =  VocaListFragmentUseCase(this, object: Callback<List<FavoriteVocaGroup>>{
        override fun onResponse(
            call: Call<List<FavoriteVocaGroup>>,
            response: Response<List<FavoriteVocaGroup>>
        ) {
            if(response.isSuccessful)
            {
                favoriteVocaGroupList.value = response.body()

            }
        }

        override fun onFailure(call: Call<List<FavoriteVocaGroup>>, t: Throwable) {
            Log.e("test", "실패 : ${t.stackTrace}, 로컬DB에서 추가")
            var result : List<FavoriteVocaGroup>
            runBlocking(Dispatchers.IO) {
                result = DataModel.favoriteVocaGroupDao.getAll()
            }
            favoriteVocaGroupList.value = result
        }
    })

    fun getVocaLists() {
        CoroutineScope(Dispatchers.IO).launch {
            vocalistFragmentUseCase.getAllVocaMyFavorite() //모든 단어를 가져온다.
        }

    }

    fun getFavoriteVocaGroup()
    {
        vocalistFragmentUseCase.getFavoriteGroup()
    }

    override fun onResponse(call: Call<List<VocaList>>, response: Response<List<VocaList>>) {   //단어 관련 수신 성공
        Log.e("test", "body : ${response.body().toString()}, ${response.isSuccessful}")
        dataList.value = response.body()
    }

    override fun onFailure(call: Call<List<VocaList>>, t: Throwable) {
        Log.e("test", "실패 : ${t.stackTrace}")
    }
}