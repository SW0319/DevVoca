package com.example.devvoca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.devvoca.Repo.FavoriteVocaGroup
import com.example.devvoca.ViewModel.MyPageFavoriteListViewModel
import com.example.devvoca.databinding.FragmentMyPageBinding

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

        return binding.root
    }
}