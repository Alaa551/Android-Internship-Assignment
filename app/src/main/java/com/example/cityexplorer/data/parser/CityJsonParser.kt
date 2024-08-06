package com.example.cityexplorer.data.parser

import android.content.Context
import android.util.Log
import com.example.cityexplorer.data.model.City
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

class CityJsonParser @Inject constructor(
    private val context: Context,
) {

    suspend fun parseCityJson(jsonFileName: String): List<City> = withContext(Dispatchers.IO) {
         try {
            val listType = object : TypeToken<List<City>>() {}.type
            val jsonString = readJsonFile(jsonFileName)

            Gson().fromJson(jsonString, listType)
        } catch (e: JsonSyntaxException) {
            Log.e("JSON Error", "Failed to parse JSON: ${e.message}")
            emptyList() // Return an empty list or handle the error as needed
        } catch (e: IOException) {
            Log.e("File Error", "Failed to read JSON file: ${e.message}")
            emptyList() // Return an empty list or handle the error as needed
        }
    }

    private fun readJsonFile(fileName: String)=
         context.assets.open(fileName).bufferedReader().use { it.readText() }


}


