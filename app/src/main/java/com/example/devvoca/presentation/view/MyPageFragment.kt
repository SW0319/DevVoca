package com.example.devvoca.presentation.view

import ObservableArrayList
import android.os.Bundle
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
    private lateinit var observableArrayList: ObservableArrayList<FavoriteVocaGroup>
    private lateinit var observableArrayList2: ObservableArrayList<Badge>
    var myPageInfoLiveData = MutableLiveData<MyPageInfo>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyPageBinding.inflate(inflater,container,false)
        myPageViewModel = MyPageViewModel(myPageInfoLiveData)

        setListener()


        //reverseLayout : true로 하면 거꾸로 배치됨
        binding.myPageBadgeView
            .apply {
                observableArrayList2 = ObservableArrayList({
                    invalidate()
                },{
                    invalidate()
                })
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                adapter = MyPageBadgeViewAdapter(observableArrayList2)
            }

        binding.myPageFavoriteView.apply {
            observableArrayList = ObservableArrayList({
                adapter?.notifyDataSetChanged()
            }, {
                adapter?.notifyDataSetChanged()
            })
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = MyPageFravoriteViewAdapter(observableArrayList)
        }


        readData()

        return binding.root
    }

    private fun readData()
    {
//        myPageInfoLiveData.value = myPageViewModel.getMyMemoryInfo();
//        observableArrayList.addAll(myPageViewModel.getMyFavoriteGroup())
//        observableArrayList2.addAll(myPageViewModel.getMyBadgeInfo())

    }

    private fun setListener()
    {
        myPageInfoLiveData.observe(viewLifecycleOwner)
        {
            binding.mypageLogincount.text = it.login_Count.toString()
            binding.mypageStudyVocaCount.text = it.study_Voca_Count.toString()
            binding.mypageStudyStreak.text = it.study_streak.toString()
            binding.mypageStudyRank.text = it.study_rank.toString()
        }
    }
}