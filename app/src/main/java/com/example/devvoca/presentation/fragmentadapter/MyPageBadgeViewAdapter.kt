package com.example.devvoca.presentation.fragmentadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.databinding.ItemsMybadgeBinding
import com.example.devvoca.domain.model.Badge

class MyPageBadgeViewAdapter(var badgeList:MutableLiveData<List<Badge>>) : RecyclerView.Adapter<MyPageBadgeViewAdapter.ViewHolder>() {

    var badgeData = badgeList.value!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsMybadgeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = badgeData[position].b_Name
    }

    override fun getItemCount(): Int {
        return badgeData.size
    }

    inner class ViewHolder(binding: ItemsMybadgeBinding) : RecyclerView.ViewHolder(binding.root)
    {
        var titleView = binding.myBadgeTitle
        var imageView = binding.myBadgeTitle
    }

}