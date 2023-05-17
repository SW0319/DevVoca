package com.example.devvoca.data.repository

import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import retrofit2.Call

interface VocaListRepository {

    suspend fun getAllVocaLists() : List<VocaList>

    fun getUpdateVocaLists() : List<VocaList>

    fun getMyFavoriteVocaLists() : IntArray

    fun getVocaListfromGroup(favoriteVocaGroup: FavoriteVocaGroup) : IntArray

    fun getStudyVocaList() : IntArray

    suspend fun getMyFavoriteVocaGroupList() : List<FavoriteVocaGroup>
}