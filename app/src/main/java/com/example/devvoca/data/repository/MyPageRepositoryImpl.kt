package com.example.devvoca.data.repository

import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.MyPageInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageRepositoryImpl : MyPageRepository{

    override fun getMyInfo(): MyPageInfo {

        //TODO : 서버단에서 정보 가져오도록 구현해야함 (서버단도 구현해야됨)

        //TODO : 테스트임으로 추후 제거
        return MyPageInfo(1,10,500,1,5)

    }

    override fun getMyFavoriteGroupInfo(): List<FavoriteVocaGroup> {    //TODO : 구현 필요

//        RetrofitCon.getWordService().getWordGroup().enqueue(object : Callback<List<FavoriteVocaGroup>> {
//            override fun onResponse(
//                call: Call<List<FavoriteVocaGroup>>,
//                response: Response<List<FavoriteVocaGroup>>
//            ) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onFailure(call: Call<List<FavoriteVocaGroup>>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })

        var test = ArrayList<FavoriteVocaGroup>()
        test.add(FavoriteVocaGroup(1,"테스트입니다."))
        test.add(FavoriteVocaGroup(2,"MyPageRepositoryImpl의 데이터"))
        test.add(FavoriteVocaGroup(355,"MyPageRepositoryImpl의 데이터!!"))

        return test
    }

    override fun getMyBadgeInfo(): List<Int> {  //TODO : 구현 필요
        return listOf()
    }
}