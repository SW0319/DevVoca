package com.example.devvoca.data.repository

import android.util.Log
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import retrofit2.Callback

class VocaListRepositoryImpl(private val callback: Callback<List<VocaList>>, private val callback2: Callback<List<FavoriteVocaGroup>>) : VocaListRepository{

    private val vocaService = RetrofitCon.getVocaService()

    override fun getAllVocaLists() {    //모든단어 가져오기
        vocaService.downloadAllVocaLists().enqueue(callback)
    }

    override fun getUpdateVocaLists(): List<VocaList> { //단어 업데이트 하기
        TODO("Not yet implemented")
    }

    override fun getMyFavoriteVocaLists(): IntArray {   //내가 즐겨찾기한 단어리스트 가져오기
        TODO("Not yet implemented")
    }

    override fun getVocaListfromGroup(favoriteVocaGroup: FavoriteVocaGroup): IntArray { //내가 즐겨찾기 한 단어 중 특정 그룹에 속한 단어들 가져오기
        TODO("Not yet implemented")
    }

    override fun getStudyVocaList(): IntArray { //내가 공부한 단어 목록 가져오기
        TODO("Not yet implemented")
    }

    override fun getFavoriteGroup() { //내가 즐겨찾기한 단어들 가져오기
        Log.e("DevVoca","userNo : ${RetrofitCon.getLoginInfoData().userNo}")
        vocaService.getVocaGroup(RetrofitCon.getLoginInfoData()).enqueue(callback2)
    }
}