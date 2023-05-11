package com.example.devvoca

import com.example.devvoca.CustomList.ObservableArrayList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.ViewModel.VocaListViewModel
import com.example.devvoca.databinding.FragmentVocaListBinding
import kotlinx.coroutines.runBlocking

class VocaListFragment : Fragment() {

    private var _binding: FragmentVocaListBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var list = ObservableArrayList<VocaList> {
            activity?.runOnUiThread {
                binding.vocalistRecyclerview.adapter?.notifyDataSetChanged()
            }
        }

        _binding = FragmentVocaListBinding.inflate(inflater, container, false)
        binding.vocalistRecyclerview.adapter = VocaListAdapter(list)
        VocaListViewModel.init(list)
        binding.vocalistRecyclerview.layoutManager = LinearLayoutManager(binding.vocalistRecyclerview.context)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}