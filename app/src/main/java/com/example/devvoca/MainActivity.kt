package com.example.devvoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.room.Room
import androidx.room.RoomDatabase
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

        Log.e("test","dd")
        val db = Room.databaseBuilder(this,AppDatabase::class.java,"word").build()
        val dao = db.wordDao()

        findViewById<Button>(R.id.inputButton1).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                dao.insert(VocaList(0,"단어","번역","예제","타입"))
            }
        }

        findViewById<Button>(R.id.searchButton).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                dao.getAll().iterator().forEach {
                    Log.e("test","번호 : ${it.v_no} voca: ${it.voca}")
                }
            }
        }
    }
}