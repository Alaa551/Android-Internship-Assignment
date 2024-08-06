package com.example.cityexplorer.repo

import com.example.cityexplorer.data.datasource.CityDataSource
import com.example.cityexplorer.data.model.City
import javax.inject.Inject

class CityRepositoryImp @Inject constructor(
    private val cityDataSource: CityDataSource,
) : CityRepository {

    override suspend fun loadCities(json: String) =
        cityDataSource.loadCities(json)


    override suspend fun filterCitiesByPrefix(prefix: String): List<City> =
        cityDataSource.filterCitiesByPrefix(prefix)


}