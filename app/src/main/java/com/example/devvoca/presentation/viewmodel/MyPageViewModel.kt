package com.example.devvoca.presentation.viewmodel

import ObservableArrayList
import androidx.lifecycle.ViewModel
import com.example.devvoca.Util.ObservableArrayListCallback
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.MyPageInfo
import com.example.devvoca.domain.usecase.MyPageFragmentUseCase

class MyPageViewModel(private var myPageFragmentUseCase: MyPageFragmentUseCase) : ViewModel() {



    fun getMyInfo(): MyPageInfo {
        return myPageFragmentUseCase.getMyInfo()
    }

    fun getMyFavoriteGroup() : List<FavoriteVocaGroup>
    {
        return myPageFragmentUseCase.getMyFavoriteGroupInfo()
    }


}