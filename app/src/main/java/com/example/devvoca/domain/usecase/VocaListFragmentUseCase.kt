package com.example.devvoca.domain.usecase

import com.example.devvoca.data.repository.VocaListRepositoryImpl
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import retrofit2.Callback

class VocaListFragmentUseCase(private val callback:Callback<List<VocaList>>, private val callback2:Callback<List<String>>){

    private val vocaListRepositoryImpl = VocaListRepositoryImpl(callback,callback2)

    fun getVocaListsFromFavoriteGroup(group: FavoriteVocaGroup? = null)
    {
        if(group == null)   //null일경우 즐겨찾기 한 모든 단어가 나온다
        {
            vocaListRepositoryImpl.getAllVocaLists()
        }
        else
        {
            vocaListRepositoryImpl.getUpdateVocaLists()
        }
        // 내가 원하는 그룹의 단어만 가져오기
    }

    fun getFavoriteGroup()
    {
        vocaListRepositoryImpl.getFavoriteGroup()
    }
}