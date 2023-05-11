package com.example.devvoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.databinding.ActivitySearchBinding
import com.example.devvoca.domain.model.VocaList

class SearchActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    lateinit var searchRecycle: RecyclerView
    lateinit var searchWordListAdapter: SearchWordListAdapter
    lateinit var words: ArrayList<VocaList>

    lateinit var searchView: SearchView

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)

        searchRecycle = binding.searchRecycle
        searchView = binding.searchView

        searchView.setOnQueryTextListener(searchViewTextListener)

        words = tempWords()
        setAdapter()
        searchWordListAdapter.filter.filter("")

        setContentView(binding.root)
    }

    private var searchViewTextListener: SearchView.OnQueryTextListener =
        object : SearchView.OnQueryTextListener {
            //검색버튼 입력시 호출, 검색버튼이 없으므로 사용하지 않음
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            //텍스트 입력/수정시에 호출
            override fun onQueryTextChange(s: String): Boolean {
                searchWordListAdapter.filter.filter(s)
                return false
            }
        }

    private fun setAdapter(){
        //리사이클러뷰에 리사이클러뷰 어댑터 부착
        searchRecycle.layoutManager = LinearLayoutManager(this)
        searchWordListAdapter = SearchWordListAdapter(words, this)
        searchRecycle.adapter = searchWordListAdapter
    }

    private fun tempWords(): ArrayList<VocaList> {
        val tempWords = ArrayList<VocaList>()
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
        return tempWords
    }
}