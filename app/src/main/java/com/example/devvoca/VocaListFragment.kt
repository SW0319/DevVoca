package com.example.devvoca

import ObservableArrayList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.Model.DataModel
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.ViewModel.VocaListViewModel
import com.example.devvoca.databinding.FragmentVocaListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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
        VocaListViewModel.init(binding.vocalistRecyclerview?.adapter!!,list)
        binding.vocalistRecyclerview.layoutManager = LinearLayoutManager(binding.vocalistRecyclerview.context)




        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}