package com.example.devvoca.presentation.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.devvoca.R
import com.example.devvoca.SearchActivity
import com.example.devvoca.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        navController = Navigation.findNavController(view)


        binding.progressBtn.setOnClickListener{
            navController.navigate(R.id.action_navigation_home_to_studyFragment)
        }

        binding.todayBtn.setOnClickListener{
            navController.navigate(R.id.action_navigation_home_to_todayFragment)
        }

        binding.searchBtn.setOnClickListener{
            activity?.let{
                val intent = Intent(context, SearchActivity::class.java)
                startActivity(intent)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}