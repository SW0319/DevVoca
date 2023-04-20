package com.example.devvoca.presentation.view

import ObservableArrayList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.presentation.fragmentadapter.VocaListAdapter
import com.example.devvoca.presentation.viewmodel.VocaListViewModel
import com.example.devvoca.databinding.FragmentVocaListBinding

class VocaListFragment : Fragment() {

    private var _binding: FragmentVocaListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //TODO : adapter, viewmodel 적용 필요

        _binding = FragmentVocaListBinding.inflate(inflater, container, false)
//        binding.vocalistRecyclerview.adapter = VocaListAdapter(list)
        binding.vocalistRecyclerview.layoutManager = LinearLayoutManager(binding.vocalistRecyclerview.context)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}