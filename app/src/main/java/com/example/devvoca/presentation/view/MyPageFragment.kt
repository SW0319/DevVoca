package com.example.devvoca.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.data.Entity.UserMemory
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.databinding.FragmentMyPageBinding
import com.example.devvoca.domain.model.Badge
import com.example.devvoca.presentation.fragmentadapter.MyPageBadgeViewAdapter
import com.example.devvoca.presentation.fragmentadapter.MyPageFravoriteViewAdapter
import com.example.devvoca.presentation.viewmodel.MyPageViewModel

class MyPageFragment : Fragment() {

    private var _binding : FragmentMyPageBinding? = null
    private val binding get() = _binding!!

    lateinit var myPageViewModel: MyPageViewModel
    private lateinit var favoriteVocaGroupLiveData: MutableLiveData<List<FavoriteVocaGroup>>
    private lateinit var badgeListLiveData: MutableLiveData<List<Badge>>
    var myPageInfoLiveData = MutableLiveData<UserMemory>()


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
        myPageViewModel.apply {
            getMyFavoriteGroup()
            getMyBadgeInfo()
            getMyMemoryInfo()
        }
//        favoriteVocaGroupLiveData.value = listOf(FavoriteVocaGroup(1,"dd"))
//        myPageInfoLiveData.value = myPageViewModel.getMyMemoryInfo();
//        observableArrayList.addAll(myPageViewModel.getMyFavoriteGroup())
//        observableArrayList2.addAll(myPageViewModel.getMyBadgeInfo())

    }

    private fun setDataObserve()
    {
        myPageInfoLiveData.observe(viewLifecycleOwner)
        {
            binding.mypageLogincount.text = it.u_subscriptionDate.toString()
            binding.mypageStudyVocaCount.text = it.u_studiedVocaTotal.toString()
            binding.mypageStudyStreak.text = it.u_attendanceStreak.toString()
            binding.mypageStudyRank.text = it.u_totalRank.toString()
        }

        favoriteVocaGroupLiveData.observe(viewLifecycleOwner)
        {
            binding.myPageFavoriteView.adapter?.notifyDataSetChanged()
        }
        badgeListLiveData.observe(viewLifecycleOwner){
            binding.myPageBadgeView.adapter?.notifyDataSetChanged()
            Log.e("test","badgeLiveDat Observed, ${badgeListLiveData.value?.size}")
        }
    }
}