package com.example.devvoca.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.devvoca.domain.model.MyPageInfo
import com.example.devvoca.domain.usecase.MyPageFragmentUseCase

class MyPageViewModel(private var myPageFragmentUseCase: MyPageFragmentUseCase) : ViewModel(){

    fun getMyInfo() : MyPageInfo
    {
        return myPageFragmentUseCase.getMyInfo()
    }

}