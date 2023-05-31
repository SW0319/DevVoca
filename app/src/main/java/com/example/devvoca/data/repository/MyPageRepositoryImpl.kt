package com.example.devvoca.data.repository

import android.util.Log
import com.example.devvoca.data.Entity.UserInfo
import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Callback
import retrofit2.await

class MyPageRepositoryImpl(private val loginInfo: UserInfo) : MyPageRepository{

    override suspend fun getMyMemoryInfo() : UserMemory{

        //TODO : 서버단에서 정보 가져오도록 구현해야함 (서버단도 구현해야됨)
        return try {
            withContext(Dispatchers.IO){
            RetrofitCon.getUserInfoService().getLoginUserMemoryInfo(loginInfo).body()!!
            }
        } catch (e : Exception)
        {
            Log.e("test","getMyMemoryInfo exception : ${e.stackTrace}")
            UserMemory(-1,0,1,2,3)
        }
        //TODO : 테스트임으로 추후 제거
//        return MyPageInfo(1,10,500,1,5)

    }

    override suspend fun getMyFavoriteGroupInfo() : List<FavoriteVocaGroup>{    //TODO : 구현 필요

//        RetrofitCon.getVocaService().getMyFavoriteVocaGroup(loginInfo).enqueue(vocaGroupCallback)

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
        test.add(FavoriteVocaGroup(1,"Android","1,2,3"))
        test.add(FavoriteVocaGroup(2,"기본 컴퓨터 지식 관련","3,4,5"))
        test.add(FavoriteVocaGroup(3,"Stack OVerFlow 자주 등장","5,6,7"))
        test.add(FavoriteVocaGroup(4,"ChatGPT는 신이야!","7,8,9"))
        test.add(FavoriteVocaGroup(5,"기타 잡다한거 보관","1,2,3"))
        test.add(FavoriteVocaGroup(6,"흐에에에ㅔ","3,45,6"))
        return test
    }

    override suspend fun getMyBadgeInfo() : List<Badge>{  //TODO : 서버단 구현 해야함

//        RetrofitCon.getUserInfoService().getLoginUserBadgeInfo(loginInfo).enqueue(badgeCallback)

        var test = ArrayList<Badge>()
        test.add(Badge(1,"첫 걸음","단어를 처음 학습할 경우 획득"))
        test.add(Badge(2,"중요한건 꺾이지 않는 마음","단어를 누적 100번이상 틀릴경우 획득"))
        test.add(Badge(3,"학살중입니다","연속 3일 학습할 경우 획득"))
        Log.e("test","getMyBadgeInfo")
        return test

    }
}