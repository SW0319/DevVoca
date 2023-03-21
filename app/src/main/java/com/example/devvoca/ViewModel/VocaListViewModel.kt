package com.example.devvoca.ViewModel

import com.example.devvoca.Repo.VocaList

class VocaListViewModel{

    var wordLists : ArrayList<VocaList> = ArrayList()

    //업데이트 삭제 선호

    //조회기능
    fun readVocaList(dbType: String)
    {

    }
    fun readAllVocaList(dbType: String)
    {

    }

    //추가 기능
    fun insertVoca(voca:String, translate:String, example:String, devType: String)
    {


    }
    fun insertVoca(dbType: String,vocaList: VocaList)
    {

    }
}