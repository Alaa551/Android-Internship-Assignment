package com.example.cityexplorer.data.datasource

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cityexplorer.data.model.City
import com.example.cityexplorer.data.parser.CityJsonParser
import com.example.cityexplorer.data.trie.Trie
import com.google.gson.JsonParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CityDataSourceImp @Inject constructor(
    private val cityJsonParser: CityJsonParser,
) : CityDataSource {

    private val trie = Trie()

    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun loadCities(json: String) = withContext(Dispatchers.IO) {
        val cities = cityJsonParser.parseCityJson(json)
        // Populate Trie with cities
        cities.forEach { trie.insert(it) }
    }

    override suspend fun filterCitiesByPrefix(prefix: String): List<City> =
        withContext(Dispatchers.Default) {
            trie.search(prefix)
        }


}