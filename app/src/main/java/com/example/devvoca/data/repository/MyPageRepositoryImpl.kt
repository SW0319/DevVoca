package com.example.devvoca.data.repository

import com.example.devvoca.data.api.RetrofitCon
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.MyPageInfo

class MyPageRepositoryImpl : MyPageRepository{

    override fun getMyInfo(): MyPageInfo {

        //TODO : 서버단에서 정보 가져오도록 구현해야함 (서버단도 구현해야됨)

        //TODO : 테스트임으로 추후 제거
        return MyPageInfo(1,10,500,1,5)

    }

    override fun getMyFavoriteGroupInfo(): List<FavoriteVocaGroup> {    //TODO : 구현 필요
        return listOf()
    }

    override fun getMyBadgeInfo(): List<Int> {  //TODO : 구현 필요
        return listOf()
    }
}