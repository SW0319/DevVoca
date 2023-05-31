package com.example.devvoca.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.usecase.MyPageFragmentUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageViewModel(var myPageInfoLiveData: MutableLiveData<UserMemory>, var myPageBadgeListLiveData: MutableLiveData<List<Badge>>
                        ,var myPageFavoriteVocagroupLiveData: MutableLiveData<List<FavoriteVocaGroup>>
) : ViewModel() {

    private var myPageFragmentUseCase = MyPageFragmentUseCase()

    fun getMyMemoryInfo(){   //최상단에 나오는 나의 정보를 가져오는 메서드
        CoroutineScope(Dispatchers.IO).launch {
            myPageInfoLiveData.postValue(myPageFragmentUseCase.getMyMemoryInfo())
        }
    }

    fun getMyFavoriteGroup()  //내 단어장 그룹을 가져온다.
    {
        CoroutineScope(Dispatchers.IO).launch {
            myPageFavoriteVocagroupLiveData.postValue(myPageFragmentUseCase.getMyFavoriteGroupInfo())
        }

    }

    fun getMyBadgeInfo()    //내 뱃지를 가져오는건 서버에서 구현한다.
    {
        CoroutineScope(Dispatchers.IO).launch {
            myPageBadgeListLiveData.postValue(myPageFragmentUseCase.getMyBadgeInfo())
            Log.e("test","myPageBadgeListLiveDat update")
        }

    }

    fun setData(source : List<*>, destination: MutableLiveData<List<*>>)
    {
        destination.value = source
    }

}