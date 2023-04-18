package com.example.devvoca.Util

interface ObservableArrayListCallback<T> {

   fun onItemListAddedCallback(item : Collection<T>) : Unit
    fun onItemAddedCallback(item : T) : Unit
   fun onItemRemoveCallback(item : T): Unit
   fun onItemUpdateCallback(item : T): Unit

}