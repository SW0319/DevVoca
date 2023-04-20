package com.example.devvoca.presentation.fragmentadapter

import ObservableArrayList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.devvoca.domain.model.VocaList
import com.example.devvoca.databinding.ItemsVocaListBinding
import com.example.devvoca.presentation.viewmodel.VocaListViewModel

class VocaListAdapter(private val dataList:MutableLiveData<List<VocaList>>) : RecyclerView.Adapter<VocaListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemsVocaListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        dataList.value?.get(position)?.apply {
            holder.view.itemsVocaListVocaName.text = vocaname
            holder.view.itemsVocaListVocaSpelling.text = howtoRead
            holder.view.itemsVocaListTranslate.text = translate
            holder.view.itemsVocaListExampleTranslate.text = exampleTranslate
        }


    }

    override fun getItemCount(): Int {
        return if(dataList.value == null) {
            0
        } else
            dataList.value!!.size
    }

    inner class ViewHolder(private val binding: ItemsVocaListBinding) : RecyclerView.ViewHolder(binding.root)
    {
        var view = binding
    }

}