package com.example.devvoca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.devvoca.Model.DataModel
import com.example.devvoca.Repo.AppDatabase
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.ViewModel.VocaListViewModel
import com.example.devvoca.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

        navView.setupWithNavController(navController)

        //test
/*
        binding.inputButton1.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                VocaListViewModel.insertVoca(DataModel.localDB, VocaList(2,"예제를 넣어보자","Spelling","해석","예제","개발타입"))
            }
        }

        binding.searchButton.setOnClickListener {
            startActivity(Intent(baseContext,VocaListActivity::class.java))

            CoroutineScope(Dispatchers.IO).launch {
                DataModel.wordDao.getAll().iterator().forEach {
                    Log.e("test","번호 : ${it.v_no} voca: ${it.voca}")
                }
            }
        }*/
    }
}