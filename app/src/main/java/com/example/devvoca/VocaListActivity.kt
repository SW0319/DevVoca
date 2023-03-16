package com.example.devvoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.databinding.ActivityVocaListBinding

class VocaListActivity : AppCompatActivity() {

    lateinit var vocaListBinding: ActivityVocaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vocaListBinding = ActivityVocaListBinding.inflate(layoutInflater)

        vocaListBinding.vocalistRecyclerview.let {
            it.adapter = VocaListAdapter()
            it.layoutManager = LinearLayoutManager(baseContext)
        }

        setContentView(vocaListBinding.root)


    }
}