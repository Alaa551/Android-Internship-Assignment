package com.example.cityexplorer.data.parser

import com.example.cityexplorer.data.model.City
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CityJsonParser {
    private val gson = Gson()

    fun parseCityJson(json: String): List<City> {
        val listType = object : TypeToken<List<City>>() {}.type
        return gson.fromJson(json, listType)
    }
}