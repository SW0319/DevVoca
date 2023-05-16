package com.example.devvoca.domain.usecase

import com.example.devvoca.data.repository.DataModel
import com.example.devvoca.data.repository.VocaListRepositoryImpl
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import retrofit2.Callback

class VocaListFragmentUseCase(private val callback:Callback<List<VocaList>>, private val callback2:Callback<List<FavoriteVocaGroup>>){

    private val vocaListRepositoryImpl = VocaListRepositoryImpl(callback,callback2)
    private val wordDao = DataModel.wordDao
    private val favoriteVocaGroupDao = DataModel.favoriteVocaGroupDao
    suspend fun getAllVocaMyFavorite() : List<VocaList>
    {
        var returnList = ArrayList<VocaList>()
        favoriteVocaGroupDao.getAll().forEach{
            it.favoriteVocaListArray.split(",").forEach{ it2 ->
                returnList.add(wordDao.getVocaListByID(it2.toInt()))
            }
        }
        return returnList
    }
    fun getVocaListsFromFavoriteGroup(group: FavoriteVocaGroup)
    {
        group.favoriteVocaListArray.split(",").forEach {
                wordDao.getVocaListByID(it.toInt())
        }
        // 내가 원하는 그룹의 단어만 가져오기굳이? 여기는 단어 그룹만 가져오고 단어 자체는 App에서 가져와야 한다.
    }

    fun getFavoriteGroup()
    {
        vocaListRepositoryImpl.getFavoriteGroup()

    }

}