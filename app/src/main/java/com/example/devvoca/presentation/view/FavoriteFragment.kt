package com.example.devvoca.presentation.view

import ObservableArrayList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        vocaListViewModel.getVocaLists()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}