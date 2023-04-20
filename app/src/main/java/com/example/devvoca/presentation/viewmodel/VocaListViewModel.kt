package com.example.devvoca.presentation.viewmodel

import ObservableArrayList
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.devvoca.data.repository.DataModel
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.data.api.VocaService
import com.example.devvoca.data.repository.VocaListRepositoryImpl
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.domain.usecase.VocaListFragmentUseCase
import com.example.devvoca.presentation.fragmentadapter.VocaListAdapter
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VocaListViewModel : Callback<List<VocaList>> {
    var vocalistFragmentUseCase =  VocaListFragmentUseCase(this)

    val dataList = MutableLiveData<List<VocaList>>().apply {
    }

    fun getVocaLists() {
        vocalistFragmentUseCase.getVocaListsFromFavoriteGroup(null) //모든 단어를 가져온다.

    }

    override fun onResponse(call: Call<List<VocaList>>, response: Response<List<VocaList>>) {
        Log.e("test", "body : ${response.body().toString()}, ${response.isSuccessful}")
        dataList.value = response.body()
    }

    override fun onFailure(call: Call<List<VocaList>>, t: Throwable) {
        Log.e("test", "실패 : ${t.stackTrace}")
    }
}