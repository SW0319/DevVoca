package com.example.devvoca

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.ViewModel.VocaListViewModel
import com.example.devvoca.databinding.FragmentMyPageBinding
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.data.RadarEntry

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyPageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyPageFragment : Fragment() {

    private var _binding : FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyPageBinding.inflate(inflater,container,false)

        //reverseLayout : true로 하면 거꾸로 배치됨
        binding.myPageBadgeView
            .apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                //adapter = ?
            }


        with(binding.myPageChartView)
        {
            data = PieData(PieDataSet(arrayListOf(PieEntry(2F,"범주1"),PieEntry(5F,"범주2"),PieEntry(10F,"범주3")),
                ""
            ).apply {
                colors = listOf(Color.BLACK, Color.BLUE, Color.GRAY)
            })
        }


        return binding.root
    }
}