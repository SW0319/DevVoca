package com.example.devvoca.ViewModel

import com.example.devvoca.Model.DataModel
import com.example.devvoca.Repo.VocaList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

object VocaListViewModel{

    var wordLists : ArrayList<VocaList> = ArrayList()

    //업데이트 삭제 선호

    //조회기능
    fun readVocaList(dbType: String)
    {

    }
    suspend fun readAllVocaList(dbType: String)
    {
            when (dbType) {
                DataModel.localDB -> {
                    wordLists.addAll(DataModel.wordDao.getAll())
                }
                DataModel.serverDB -> {
                    //TODO : 백엔드 필요
                }
            }
    }

    //추가 기능
    suspend fun insertVoca(dbType: String,voca:String, translate:String, example:String, devType: String) = insertVoca(dbType, VocaList(0,voca,translate,example,devType))

    suspend fun insertVoca(dbType: String,vocaList: VocaList)
    {
        when(dbType)
        {
            DataModel.localDB -> {
                DataModel.wordDao.insert(vocaList)
                wordLists.add(vocaList)
            }
            DataModel.serverDB -> {
                //TODO : 백엔드 확정되면 작업해야됨
            }
        }
    }
}