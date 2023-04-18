package com.example.devvoca.presentation.view

import ObservableArrayList
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.data.repository.MyPageRepositoryImpl
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.presentation.viewmodel.MyPageFavoriteListViewModel
import com.example.devvoca.databinding.FragmentMyPageBinding
import com.example.devvoca.domain.model.MyPageInfo
import com.example.devvoca.domain.usecase.MyPageFragmentUseCase
import com.example.devvoca.presentation.fragmentadapter.MyPageFravoriteViewAdapter
import com.example.devvoca.presentation.viewmodel.MyPageViewModel
import java.util.ArrayList

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

    lateinit var myPageViewModel: MyPageViewModel
    lateinit var observableArrayList: ObservableArrayList<FavoriteVocaGroup>
    var d = MutableLiveData<MyPageInfo>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyPageBinding.inflate(inflater,container,false)
        myPageViewModel = MyPageViewModel(MyPageFragmentUseCase(MyPageRepositoryImpl()))

        setListener()


        //reverseLayout : true로 하면 거꾸로 배치됨
        binding.myPageBadgeView
            .apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                //adapter = ?
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
        d.value = myPageViewModel.getMyInfo();
        observableArrayList.addAll(myPageViewModel.getMyFavoriteGroup())

    }

    private fun setListener()
    {
        d.observe(viewLifecycleOwner)
        {
            binding.mypageLogincount.text = it.login_Count.toString()
            binding.mypageStudyVocaCount.text = it.study_Voca_Count.toString()
            binding.mypageStudyStreak.text = it.study_streak.toString()
            binding.mypageStudyRank.text = it.study_rank.toString()
        }
    }
}