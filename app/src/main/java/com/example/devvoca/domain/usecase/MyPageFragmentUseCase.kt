package com.example.devvoca.domain.usecase

import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.data.repository.MyPageRepositoryImpl
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup
import retrofit2.Callback

class MyPageFragmentUseCase(myMemoryCallback: Callback<UserMemory>, vocaGroupCallback: Callback<List<FavoriteVocaGroup>>, badgeCallback: Callback<List<Badge>>) {   //데이터를 가져오는 기능 별 정리

    //repository interface 가져옴 (repository는 domain에 의존성이 생긴다)
    private val myPageRepositoryImpl = MyPageRepositoryImpl(RetrofitCon.getLoginInfoData(),myMemoryCallback, vocaGroupCallback, badgeCallback)
//    private val myPageRepositoryImpl = MyPageRepositoryImpl(RetrofitCon.getLoginInfoData_testData(),myMemoryCallback, vocaGroupCallback, badgeCallback)

    fun getMyMemoryInfo()//내 정보를 가져옴 (로그인 일수, 누적 학습 개수 및 평균 등)
    {
        myPageRepositoryImpl.getMyMemoryInfo()
    }
    fun getMyFavoriteGroupInfo()    //나의 즐겨찾기 정보를 가져옴
    {
        myPageRepositoryImpl.getMyFavoriteGroupInfo()
    }

    fun getMyBadgeInfo()  //나의 뱃지를 가져옴 (일종의 업적 기능)
    {
        myPageRepositoryImpl.getMyBadgeInfo()
    }
}