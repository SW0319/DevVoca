package com.example.devvoca.domain.usecase

import com.example.devvoca.data.repository.DataModel
import com.example.devvoca.data.repository.VocaListRepositoryImpl
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VocaListFragmentUseCase{

    private val vocaListRepositoryImpl = VocaListRepositoryImpl()
    suspend fun getAllVocaMyFavorite() : List<VocaList>
    {
        return vocaListRepositoryImpl.getAllVocaLists()
    }
    suspend fun getVocaListsFromFavoriteGroup(group: FavoriteVocaGroup) : List<VocaList>
    {

        return vocaListRepositoryImpl.getVocaListfromGroup(group)
        // 내가 원하는 그룹의 단어만 가져오기굳이? 여기는 단어 그룹만 가져오고 단어 자체는 App에서 가져와야 한다.
    }

    suspend fun getMyFavoriteVocaGroupNameList() : List<FavoriteVocaGroup>
    {
        return vocaListRepositoryImpl.getMyFavoriteVocaGroupList()
    }

}