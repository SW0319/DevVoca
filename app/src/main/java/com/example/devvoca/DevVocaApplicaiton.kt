package com.example.devvoca

import android.app.Application
import com.example.devvoca.data.repository.DataModel

class DevVocaApplicaiton : Application() {


    override fun onCreate() {
        super.onCreate()
        DataModel.init(baseContext)
    }
}