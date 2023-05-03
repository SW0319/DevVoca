package com.example.devvoca.today

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devvoca.HomeFragment
import com.example.devvoca.databinding.FragmentTodayBinding

class TodayFragment : Fragment() {

    companion object {
        fun newInstance() = TodayFragment()
    }

    private var _binding: FragmentTodayBinding? = null
    private lateinit var viewModel: TodayViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[TodayViewModel::class.java]

        _binding = FragmentTodayBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}