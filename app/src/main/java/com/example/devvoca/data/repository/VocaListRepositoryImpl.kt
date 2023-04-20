package com.example.devvoca.data.repository

import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VocaListRepositoryImpl(private val callback: Callback<List<VocaList>>) : VocaListRepository{

    private val vocaService = RetrofitCon.getVocaService()

    override fun getAllVocaLists() {
        vocaService.downloadAllVocaLists().enqueue(callback)
    }

    override fun getUpdateVocaLists(): List<VocaList> {
        TODO("Not yet implemented")
    }

    override fun getMyFavoriteVocaLists(): IntArray {
        TODO("Not yet implemented")
    }

    override fun getVocaListfromGroup(favoriteVocaGroup: FavoriteVocaGroup): IntArray {
        TODO("Not yet implemented")
    }

    override fun getStudyVocaList(): IntArray {
        TODO("Not yet implemented")
    }
}