package com.example.devvoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.Model.DataModel
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.ViewModel.VocaListViewModel
import com.example.devvoca.databinding.ActivityVocaListBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class VocaListActivity : AppCompatActivity() {

    lateinit var vocaListBinding: ActivityVocaListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vocaListBinding = ActivityVocaListBinding.inflate(layoutInflater)

        vocaListBinding.vocalistRecyclerview.let {
            it.adapter = VocaListAdapter(VocaListViewModel.wordLists)
            it.layoutManager = LinearLayoutManager(baseContext)
            runBlocking(Dispatchers.IO) {VocaListViewModel.readAllVocaList(DataModel.localDB)}
        }
        setContentView(vocaListBinding.root)
    }
}