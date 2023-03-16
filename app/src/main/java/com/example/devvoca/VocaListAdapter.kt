package com.example.devvoca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.Repo.VocaList
import com.example.devvoca.databinding.ItemsVocaListBinding

class VocaListAdapter : RecyclerView.Adapter<VocaListAdapter.ViewHolder>() {

    var data : ArrayList<VocaList> = ArrayList()

    init {
        data.add(VocaList(0,"영어","해석","예제","타입"))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsVocaListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.itemsVocaListVocaName.text = data[position].voca
        holder.view.itemsVocaListTranslate.text= data[position].translate
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(private val binding: ItemsVocaListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        var view = binding
    }

}