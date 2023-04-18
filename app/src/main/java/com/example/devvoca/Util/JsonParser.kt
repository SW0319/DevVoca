package com.example.devvoca.Util

import com.google.gson.Gson

object JsonParser {

    var gson = Gson()

    inline fun <reified T> jsonToClass(json : String) : T
    {
        return gson.fromJson(json,T::class.java)
    }

    fun <T> classToJson(obj : T) : String
    {
        return gson.toJson(obj)
    }

}