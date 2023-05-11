package com.example.devvoca.study

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.devvoca.HomeFragment
import com.example.devvoca.databinding.FragmentStudyBinding

class StudyFragment : Fragment() {

    companion object {
        fun newInstance() = StudyFragment()
    }

    private var _binding: FragmentStudyBinding? = null
    private lateinit var viewModel: StudyViewModel
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[StudyViewModel::class.java]

        _binding = FragmentStudyBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}