package com.example.devvoca.presentation.viewmodel

import android.util.Log
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.FavoriteVocaGroup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageFavoriteListViewModel : Callback<List<FavoriteVocaGroup>>{

    var itemList = ArrayList<FavoriteVocaGroup>()

    fun getList() = itemList

    constructor()
    {
     readVocaGroup()
    }


    fun addVocaGroup(group : FavoriteVocaGroup)
    {
        itemList.add(group)
    }

    private fun readVocaGroup()
    {
        RetrofitCon.getWordService().getWordGroup().enqueue(this)
    }

    override fun onResponse(
        call: Call<List<FavoriteVocaGroup>>,
        response: Response<List<FavoriteVocaGroup>>
    ) {
        if(response.isSuccessful)
        {
            response.body()?.forEach{
                itemList.add(it)
            }
        }
    }

    override fun onFailure(call: Call<List<FavoriteVocaGroup>>, t: Throwable) {
        Log.e("test",t.stackTrace.toString())
    }
}
