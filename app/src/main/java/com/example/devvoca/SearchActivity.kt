package com.example.devvoca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    lateinit var rv_phone_book: RecyclerView
    lateinit var phoneBookListAdapter: PhoneBookListAdapter
    lateinit var persons: ArrayList<Person>

    lateinit var search_view_phone_book: SearchView

    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)

        rv_phone_book = binding.searchHint
        search_view_phone_book = binding.searchView

        search_view_phone_book.setOnQueryTextListener(searchViewTextListener)

        persons = tempPersons()
        setAdapter()

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
                phoneBookListAdapter.filter.filter(s)
                Log.d(TAG, "SearchVies Text is changed : $s")
                return false
            }
        }

    private fun setAdapter(){
        //리사이클러뷰에 리사이클러뷰 어댑터 부착
        rv_phone_book.layoutManager = LinearLayoutManager(this)
        phoneBookListAdapter = PhoneBookListAdapter(persons, this)
        rv_phone_book.adapter = phoneBookListAdapter
    }

    private fun tempPersons(): ArrayList<Person> {
        var tempPersons = ArrayList<Person>()
        tempPersons.add(Person(1, "kim", "01011111111"))
        tempPersons.add(Person(2, "lee", "01022222222"))
        tempPersons.add(Person(3, "park", "01033333333"))
        tempPersons.add(Person(4, "son", "01044444444"))
        tempPersons.add(Person(5, "hwang", "01055555555"))
        tempPersons.add(Person(6, "jo", "01066666666"))
        tempPersons.add(Person(7, "gwak", "01077777777"))
        tempPersons.add(Person(8, "sim", "01088888888"))
        tempPersons.add(Person(9, "choi", "01099999999"))
        return tempPersons
    }

}