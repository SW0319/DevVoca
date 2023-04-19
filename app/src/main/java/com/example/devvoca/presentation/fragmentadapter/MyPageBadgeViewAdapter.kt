package com.example.devvoca.presentation.fragmentadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.databinding.ItemsMybadgeBinding
import com.example.devvoca.domain.model.Badge

class MyPageBadgeViewAdapter(var badgeList:ArrayList<Badge>) : RecyclerView.Adapter<MyPageBadgeViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsMybadgeBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleView.text = badgeList[position].b_Name
    }

    override fun getItemCount(): Int {
        return badgeList.size
    }

    inner class ViewHolder(binding: ItemsMybadgeBinding) : RecyclerView.ViewHolder(binding.root)
    {
        var titleView = binding.myBadgeTitle
        var imageView = binding.myBadgeTitle
    }

}