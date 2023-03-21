package com.example.devvoca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.devvoca.Model.DataModel
import com.example.devvoca.Repo.AppDatabase
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.databinding.ActivityMainBinding
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


        binding.inputButton1.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                DataModel.wordDao.insert(VocaList(0,"단어","번역","예제","타입"))
            }
        }

        binding.searchButton.setOnClickListener {
            startActivity(Intent(baseContext,VocaListActivity::class.java))

            CoroutineScope(Dispatchers.IO).launch {
                DataModel.wordDao.getAll().iterator().forEach {
                    Log.e("test","번호 : ${it.v_no} voca: ${it.voca}")
                }
            }
        }
    }
}