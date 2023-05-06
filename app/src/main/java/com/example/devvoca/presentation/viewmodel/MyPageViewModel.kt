package com.example.devvoca.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.MyPageInfo
import com.example.devvoca.domain.usecase.MyPageFragmentUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyPageViewModel(myPageInfoLiveData: MutableLiveData<MyPageInfo>, myPageBadgeListLiveData: MutableLiveData<List<Badge>>
                        ,myPageFavoriteVocagroupLiveData: MutableLiveData<List<FavoriteVocaGroup>>
) : ViewModel() {

    var myPageMemoryCallback = object : Callback<UserMemory> {
        override fun onResponse(call: Call<UserMemory>, response: Response<UserMemory>) {
            if(response.isSuccessful)
            {
                //myPageLiveData = ?
            }
        }

        override fun onFailure(call: Call<UserMemory>, t: Throwable) {
            Log.e("DevVoca","$t")
        }
    }

    //My Page Badge에 대한 callback
    var myPageBadgeCallback = object:Callback<List<Badge>>{
        override fun onResponse(call: Call<List<Badge>>, response: Response<List<Badge>>) {
            if(response.isSuccessful)
            {
                response.body()?.forEach {
                    Log.e("test",it.b_Name)
                }
            }
        }
        override fun onFailure(call: Call<List<Badge>>, t: Throwable) {
            Log.e("DevVoca","$t")
        }
    }

    //My Page의 FavoriteVocaGroup에 대한 callback
    private var myPageFavoriteVocaGroupCallback = object : Callback<List<FavoriteVocaGroup>>
    {
        override fun onResponse(
            call: Call<List<FavoriteVocaGroup>>,
            response: Response<List<FavoriteVocaGroup>>
        ) {
            if(response.isSuccessful)
            {
                Log.e("DevVoca","response is successful")
                myPageFavoriteVocagroupLiveData.value = response.body()
            }
        }
        override fun onFailure(call: Call<List<FavoriteVocaGroup>>, t: Throwable) {
            Log.e("DevVoca","$t")
        }
    }

    private var myPageFragmentUseCase = MyPageFragmentUseCase(myPageMemoryCallback,myPageFavoriteVocaGroupCallback, myPageBadgeCallback )

    fun getMyMemoryInfo(){   //최상단에 나오는 나의 정보를 가져오는 메서드

        myPageFragmentUseCase.getMyMemoryInfo()
    }

    fun getMyFavoriteGroup()  //내 단어장 그룹을 가져온다.
    {
        myPageFragmentUseCase.getMyFavoriteGroupInfo()
    }

    fun getMyBadgeInfo()    //내 뱃지를 가져오는건 서버에서 구현한다.

    {
        myPageFragmentUseCase.getMyBadgeInfo()
    }

    fun setData(source : List<*>, destination: MutableLiveData<List<*>>)
    {
        destination.value = source
    }

}