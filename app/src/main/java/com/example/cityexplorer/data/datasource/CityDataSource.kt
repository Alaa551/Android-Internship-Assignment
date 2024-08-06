package com.example.cityexplorer.data.datasource

import com.example.cityexplorer.data.model.City

interface CityDataSource {
   suspend fun loadCities(json: String)
   suspend fun filterCitiesByPrefix(prefix: String): List<City>
}