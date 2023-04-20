package com.example.devvoca.data.repository

import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList

interface VocaListRepository {

    fun getAllVocaLists()

    fun getUpdateVocaLists() : List<VocaList>

    fun getMyFavoriteVocaLists() : IntArray

    fun getVocaListfromGroup(favoriteVocaGroup: FavoriteVocaGroup) : IntArray

    fun getStudyVocaList() : IntArray
}