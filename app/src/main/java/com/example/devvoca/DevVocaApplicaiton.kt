package com.example.devvoca

import android.app.Application
import android.content.Intent
import androidx.preference.PreferenceManager
import com.example.devvoca.data.repository.DataModel
import com.example.devvoca.presentation.view.LoginActivity

class DevVocaApplicaiton : Application() {


    override fun onCreate() {
        super.onCreate()
        DataModel.init(baseContext)


        var intent : Intent
        if(PreferenceManager.getDefaultSharedPreferences(baseContext).getString("name","") == "")
        {
            intent = Intent(this,LoginActivity::class.java)
        }
        else
        {
            intent = Intent("com.exmaple.devocaMain")
        }
            startActivity(intent)
    }
}