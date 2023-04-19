package com.example.devvoca.data.repository

import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.Badge
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


        //Test 데이터 return
        var test = ArrayList<FavoriteVocaGroup>()
        test.add(FavoriteVocaGroup(1,"테스트입니다."))
        test.add(FavoriteVocaGroup(2,"MyPageRepositoryImpl의 데이터"))
        test.add(FavoriteVocaGroup(355,"MyPageRepositoryImpl의 데이터!!"))

        return test
    }

    override fun getMyBadgeInfo(): List<Badge> {  //TODO : 서버단 구현 해야함

        var test = ArrayList<Badge>()
        test.add(Badge(1,"첫 걸음","단어를 처음 학습할 경우 획득"))
        test.add(Badge(2,"중요한건 꺾이지 않는 마음","단어를 누적 100번이상 틀릴경우 획득"))
        test.add(Badge(3,"학살중입니다","연속 3일 학습할 경우 획득"))
        return test
    }
}