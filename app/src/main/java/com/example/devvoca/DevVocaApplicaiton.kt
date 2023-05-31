package com.example.devvoca

import android.app.Application
import android.content.Intent
import android.util.Log
import androidx.preference.PreferenceManager
import com.example.devvoca.data.repository.DataModel
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.presentation.view.LoginActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DevVocaApplicaiton : Application() {


    override fun onCreate() {
        super.onCreate()
        var tempWords = ArrayList<VocaList>()
        tempWords.add(VocaList(1, "fear", "공포, 두려움, 무서움","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(2, "halve", "반으로 줄다[줄이다]","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(3, "prattle", "(쓸데없이 마구) 지껄이다","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(4, "facelift", "주름(살) 제거 수술","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(5, "homogeneous", "동종[동질]의","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(6, "twee", "(우스꽝스러울 정도로) 앙증맞은; 감상적으로 보이는","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(7, "blend", "섞다, 혼합하다","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(8, "capture", "포로로 잡다, 억류하다; 포획하다","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(9, "captivity", "감금, 억류","translate","example","exampleTranslate",1))
        tempWords.add(VocaList(10, "monstrosity", "아주 크고 흉물스러운 것(특히 건물)","translate","example","exampleTranslate",1))
        DataModel.init(baseContext).apply {
            CoroutineScope(Dispatchers.IO).launch {
            DataModel.wordDao.removeAll()
                DataModel.favoriteVocaGroupDao.removeAll()
             tempWords.forEach{

                     DataModel.wordDao.insert(it)
                }
                 DataModel.favoriteVocaGroupDao.insertData(FavoriteVocaGroup(0,"이름","1,4,8"))
                 DataModel.favoriteVocaGroupDao.insertData(FavoriteVocaGroup(1,"이름22","1,2,8"))
                 DataModel.favoriteVocaGroupDao.insertData(FavoriteVocaGroup(2,"이름333","2,4,10"))

            }
        }


        var intent : Intent
        if(PreferenceManager.getDefaultSharedPreferences(baseContext).getString("name","") == "")
        {
            intent = Intent(this,LoginActivity::class.java)
        }
        else
        {
            intent = Intent("com.exmaple.devocaMain")
        }
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
    }
}