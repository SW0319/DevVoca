package com.example.devvoca.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.domain.usecase.VocaListFragmentUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VocaListViewModel{

    val dataList = MutableLiveData<List<VocaList>>()

    val favoriteVocaGroupList = MutableLiveData<List<FavoriteVocaGroup>>().apply {
        value = listOf()
    }

    private var vocalistFragmentUseCase =  VocaListFragmentUseCase()

    fun getAllMyFavoriteVocaLists() {
        CoroutineScope(Dispatchers.IO).launch {
            vocalistFragmentUseCase.getAllVocaMyFavorite() //모든 단어를 가져온다.
        }

    }

    fun getFavoriteVocaGroupNameLists()
    {
        CoroutineScope(Dispatchers.IO).launch {
         favoriteVocaGroupList.postValue(vocalistFragmentUseCase.getMyFavoriteVocaGroupNameList())
        }

    }
}