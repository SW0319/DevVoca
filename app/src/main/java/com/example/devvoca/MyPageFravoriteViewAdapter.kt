package com.example.devvoca

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.Repo.FavoriteVocaGroup
import com.example.devvoca.databinding.ItemsFavoritevocaGroupBinding

class MyPageFravoriteViewAdapter(arrayList: ArrayList<FavoriteVocaGroup>) : RecyclerView.Adapter<MyPageFravoriteViewAdapter.ViewHolder>(){ //recyclerview와 viewmodel을 이어주는 역할을 함

    var arrayList = arrayList


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =  ViewHolder(ItemsFavoritevocaGroupBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        arrayList[position].apply {
            holder.name.text = favoriteGroupName
            holder.count.text = "개수 : ${group_No.toString()}"
        }
    }

    override fun getItemCount(): Int = arrayList.size

    inner class ViewHolder(binding : ItemsFavoritevocaGroupBinding) : RecyclerView.ViewHolder(binding.root)
    {

        var name = binding.hobbyName
        var count = binding.hobbyCount


    }

}