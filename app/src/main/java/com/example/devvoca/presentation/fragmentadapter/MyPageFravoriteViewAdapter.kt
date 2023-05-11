package com.example.devvoca.presentation.fragmentadapter

import ObservableArrayList
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.domain.model.FavoriteVocaGroup
import com.example.devvoca.databinding.ItemsFavoritevocaGroupBinding

class MyPageFravoriteViewAdapter(var favoriteVocaGroupData: MutableLiveData<List<FavoriteVocaGroup>>) : RecyclerView.Adapter<MyPageFravoriteViewAdapter.ViewHolder>(){ //recyclerview와 viewmodel을 이어주는 역할을 함


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemsFavoritevocaGroupBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("DevVoca","pos : $position")
        favoriteVocaGroupData.value!![position].apply {
            holder.name.text = favoriteGroupName
            holder.count.text = "개수 : ${group_No.toString()}"
        }
    }
    //asdfsafsasdfdsafdas
    override fun getItemCount(): Int = favoriteVocaGroupData.value!!.size

    inner class ViewHolder(binding : ItemsFavoritevocaGroupBinding) : RecyclerView.ViewHolder(binding.root)
    {

        var name = binding.hobbyName
        var count = binding.hobbyCount


    }

}