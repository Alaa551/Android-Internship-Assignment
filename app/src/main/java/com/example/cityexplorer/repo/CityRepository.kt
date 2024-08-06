package com.example.cityexplorer.repo

import com.example.cityexplorer.data.model.City

interface CityRepository {
   suspend fun loadCities(json: String)
   suspend fun filterCitiesByPrefix(prefix: String): List<City>
}