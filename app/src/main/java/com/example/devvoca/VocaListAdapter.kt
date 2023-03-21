package com.example.devvoca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.databinding.ItemsVocaListBinding

class VocaListAdapter(data: ArrayList<VocaList>) : RecyclerView.Adapter<VocaListAdapter.ViewHolder>() {

    var dataList : ArrayList<VocaList>

    init {
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsVocaListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.itemsVocaListVocaName.text = dataList[position].voca
        holder.view.itemsVocaListTranslate.text= dataList[position].translate
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(private val binding: ItemsVocaListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        var view = binding
    }

}