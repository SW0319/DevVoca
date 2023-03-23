package com.example.devvoca.ViewModel

import android.util.Log
import com.example.devvoca.Model.DataModel
import com.example.devvoca.Repo.VocaList
import kotlinx.coroutines.*

object VocaListViewModel{

    var wordLists : ArrayList<VocaList> = ArrayList()

    //업데이트 삭제 선호

    init {
        CoroutineScope(Dispatchers.IO)
            .launch {
                readAllVocaList(DataModel.localDB)
            }
    }

    //조회기능
    fun readVocaList(dbType: String)
    {

    }
    suspend fun readAllVocaList(dbType: String)
    {
            when (dbType) {
                DataModel.localDB -> {

                    wordLists.addAll(DataModel.wordDao.getAll().apply { Log.e("test","사이즈 : ${size}") })
                }
                DataModel.serverDB -> {
                    //TODO : 백엔드 필요
                }
            }
    }

    //추가 기능
    suspend fun insertVoca(dbType: String,voca:String, vocaReading : String, translate:String, example:String, devType: String) =
        insertVoca(dbType, VocaList(0,voca,vocaReading,translate,example,devType))

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