package com.example.devvoca.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.databinding.FragmentMyPageBinding
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.domain.model.MyPageInfo
import com.example.devvoca.presentation.fragmentadapter.MyPageBadgeViewAdapter
import com.example.devvoca.presentation.fragmentadapter.MyPageFravoriteViewAdapter
import com.example.devvoca.presentation.viewmodel.MyPageViewModel

class MyPageFragment : Fragment() {

    private var _binding : FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    lateinit var myPageViewModel: MyPageViewModel
    private lateinit var favoriteVocaGroupLiveData: MutableLiveData<List<FavoriteVocaGroup>>
    private lateinit var badgeListLiveData: MutableLiveData<List<Badge>>
    var myPageInfoLiveData = MutableLiveData<MyPageInfo>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyPageBinding.inflate(inflater,container,false)

        //reverseLayout : true로 하면 거꾸로 배치됨
        binding.myPageBadgeView
            .apply {
                badgeListLiveData = MutableLiveData<List<Badge>>().apply {
                    value = ArrayList()
                }
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter = MyPageBadgeViewAdapter(badgeListLiveData)
            }

        binding.myPageFavoriteView.apply {
            favoriteVocaGroupLiveData = MutableLiveData<List<FavoriteVocaGroup>>().apply {
                value = ArrayList()
            }
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = MyPageFravoriteViewAdapter(favoriteVocaGroupLiveData)
        }
        myPageViewModel = MyPageViewModel(myPageInfoLiveData,badgeListLiveData,favoriteVocaGroupLiveData)
        setDataObserve()
        readData()

        return binding.root
    }

    private fun readData()
    {
        myPageViewModel.getMyFavoriteGroup()
//        favoriteVocaGroupLiveData.value = listOf(FavoriteVocaGroup(1,"dd"))
//        myPageInfoLiveData.value = myPageViewModel.getMyMemoryInfo();
//        observableArrayList.addAll(myPageViewModel.getMyFavoriteGroup())
//        observableArrayList2.addAll(myPageViewModel.getMyBadgeInfo())

    }

    private fun setDataObserve()
    {
        myPageInfoLiveData.observe(viewLifecycleOwner)
        {
            binding.mypageLogincount.text = it.login_Count.toString()
            binding.mypageStudyVocaCount.text = it.study_Voca_Count.toString()
            binding.mypageStudyStreak.text = it.study_streak.toString()
            binding.mypageStudyRank.text = it.study_rank.toString()
        }

        favoriteVocaGroupLiveData.observe(viewLifecycleOwner)
        {
            Log.e("DevVoca","obser완료, data : ${favoriteVocaGroupLiveData.value?.size}")
            binding.myPageFavoriteView.adapter?.notifyDataSetChanged()
        }
    }
}