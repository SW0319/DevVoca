package com.example.devvoca.domain.usecase

import com.example.devvoca.data.repository.MyPageRepositoryImpl
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.MyPageInfo

class MyPageFragmentUseCase(private val myPageRepositoryImpl: MyPageRepositoryImpl) {   //데이터를 가져오는 기능 별 정리

    //repository interface 가져옴 (repository는 domain에 의존성이 생긴다)


    fun getMyInfo() : MyPageInfo//내 정보를 가져옴 (로그인 일수, 누적 학습 개수 및 평균 등)
    {
        return myPageRepositoryImpl.getMyInfo()
    }
    fun getMyFavoriteGroupInfo() : List<FavoriteVocaGroup>    //나의 즐겨찾기 정보를 가져옴
    {
        return myPageRepositoryImpl.getMyFavoriteGroupInfo()
    }

    fun getMyBadgeInfo() :List<Badge>   //나의 뱃지를 가져옴 (일종의 업적 기능)
    {
        return myPageRepositoryImpl.getMyBadgeInfo()
    }
}