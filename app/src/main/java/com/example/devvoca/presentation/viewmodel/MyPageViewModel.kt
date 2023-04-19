package com.example.devvoca.presentation.viewmodel

import ObservableArrayList
import androidx.lifecycle.ViewModel
import com.example.devvoca.Util.ObservableArrayListCallback
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.MyPageInfo
import com.example.devvoca.domain.usecase.MyPageFragmentUseCase

class MyPageViewModel(private var myPageFragmentUseCase: MyPageFragmentUseCase) : ViewModel() {



    fun getMyInfo(): MyPageInfo {   //최상단에 나오는 나의 정보를 가져오는 메서드
        return myPageFragmentUseCase.getMyInfo()
    }

    fun getMyFavoriteGroup() : List<FavoriteVocaGroup>  //내 단어장 그룹을 가져온다.
    {
        return myPageFragmentUseCase.getMyFavoriteGroupInfo()
    }

    fun getMyBadge() : List<Badge>    //내 뱃지를 가져오는건 서버에서 구현한다.

    {
        return myPageFragmentUseCase.getMyBadgeInfo()
    }


}