package com.example.devvoca.data.repository

import android.util.Log
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback

class VocaListRepositoryImpl : VocaListRepository{

    private val vocaService = RetrofitCon.getVocaService()
    private val wordDao = DataModel.wordDao
    private val favoriteVocaGroupDao = DataModel.favoriteVocaGroupDao
    override suspend fun getAllVocaLists(): List<VocaList> {
        return wordDao.getAll()
//        return try {
//            val result = withContext(Dispatchers.IO) {
//                vocaService.downloadAllVocaLists()
//            }
//            result.body()!!
//        }catch (e : Exception) {
//            Log.e("test","통신 실패하여 local Data 반환")
//            wordDao.getAll()
//        }
    }

    override fun getUpdateVocaLists(): List<VocaList> { //단어 업데이트 하기
        TODO("Not yet implemented")
    }

    override fun getMyFavoriteVocaLists(): IntArray {   //내가 즐겨찾기한 단어리스트 가져오기
        TODO("Not yet implemented")
    }

    override suspend fun getVocaListfromGroup(favoriteVocaGroup: FavoriteVocaGroup): List<VocaList> { //내가 즐겨찾기 한 단어 중 특정 그룹에 속한 단어들 가져오기
        return try {
            withContext(Dispatchers.IO)
            {
                var result = ArrayList<VocaList>()
                favoriteVocaGroup.favoriteVocaListArray.split(",").forEach {
                    result.add(wordDao.getVocaListByID(it.toInt()))
                }
                result
            }
        } catch (e : Exception)
        {
            wordDao.getAll()
        }

    }

    override fun getStudyVocaList(): IntArray { //내가 공부한 단어 목록 가져오기
        TODO("Not yet implemented")
    }

    override suspend fun getMyFavoriteVocaGroupList(): List<FavoriteVocaGroup> {
        return try{
            withContext(Dispatchers.IO)
            {
                vocaService.getMyFavoriteVocaGroup(RetrofitCon.getLoginInfoData_testData()).body()!!
            }
        }
        catch (e : Exception)
        {
            Log.e("test","Exception 발생하여 테스트 데이터를 반환")
            return favoriteVocaGroupDao.getAll()
        }
    }
}