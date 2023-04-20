package com.example.devvoca.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.devvoca.R
import com.example.devvoca.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {


    //ㅁㄴㅇㅁㄴㅇㅁㄴㅇdd

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)

//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_favorite, R.id.navigation_my_page
//            )
//        )
//        setupActionBarWithNavController(navController, appBarConfiguration)

        navView.setupWithNavController(navController)
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