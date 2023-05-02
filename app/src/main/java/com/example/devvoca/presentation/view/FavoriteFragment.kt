package com.example.devvoca.presentation.view

import android.R
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.databinding.FragmentFavoriteBinding
import com.example.devvoca.presentation.fragmentadapter.VocaListAdapter
import com.example.devvoca.presentation.viewmodel.VocaListViewModel

class FavoriteFragment : Fragment() {

    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private lateinit var vocaListViewModel: VocaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteBinding.inflate(inflater,container,false)

        vocaListViewModel = VocaListViewModel()
        binding.favoriteVocaListView.apply {
            adapter =VocaListAdapter(vocaListViewModel.dataList.apply {
                observe(viewLifecycleOwner){
                    adapter?.notifyDataSetChanged()}
            })
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        }

        binding.favoriteListItem.adapter = ArrayAdapter(
            requireContext(), R.layout.simple_spinner_item, vocaListViewModel.favoriteVocaGroupList.value?.toMutableList()!!)
            .apply {
                vocaListViewModel.favoriteVocaGroupList.observe(viewLifecycleOwner)
                {
                    Log.e("test","favoriteVocaListChanged") //notify가 안되서 수동으로 하도록 설정해놨음.
                    this.clear()
                    this.addAll(vocaListViewModel.favoriteVocaGroupList.value!!)
                }
            }

        vocaListViewModel.getVocaLists()
        vocaListViewModel.getFavoriteVocaGroup()

//        vocaListViewModel.favoriteVocaGroupList.value = listOf("test1","test2","test3")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}