package com.example.devvoca.presentation.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
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

    lateinit var mypageViewModel: MyPageViewModel
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
        mypageViewModel = MyPageViewModel(MyPageFragmentUseCase(MyPageRepositoryImpl()))

        setListener()


        //reverseLayout : true로 하면 거꾸로 배치됨
        binding.myPageBadgeView
            .apply {
                layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
                //adapter = ?
            }

        binding.myPageFavoriteView.apply {

            layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
            adapter = MyPageFravoriteViewAdapter(MyPageFavoriteListViewModel().apply {
                addVocaGroup(FavoriteVocaGroup(1,"테스트1",))
                addVocaGroup(FavoriteVocaGroup(2,"테스트2",))
                addVocaGroup(FavoriteVocaGroup(3,"테스트3",))
                addVocaGroup(FavoriteVocaGroup(4,"테스트4",))
                addVocaGroup(FavoriteVocaGroup(5,"테스트5",))
            }.getList())
        }

        readData()

        return binding.root
    }

    private fun readData()
    {
        d.value = mypageViewModel.getMyInfo()
    }

    fun setListener()
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