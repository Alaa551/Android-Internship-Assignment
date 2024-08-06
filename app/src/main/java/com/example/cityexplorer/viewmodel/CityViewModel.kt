package com.example.cityexplorer.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cityexplorer.data.datasource.CityDataSource
import com.example.cityexplorer.data.model.City
import com.example.cityexplorer.repo.CityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityRepository: CityRepository,
) : ViewModel() {

    private val _filteredCities = MutableLiveData<List<City>>()
    val filteredCities: LiveData<List<City>>
        get() = _filteredCities

    init {
        loadCities("cities.json")
    }

    private fun loadCities(json: String) {
        viewModelScope.launch {
            cityRepository.loadCities(json)
        }
    }

    fun filterCities(prefix: String) {
        viewModelScope.launch {
            _filteredCities.value = cityRepository.filterCitiesByPrefix(prefix)
        }
    }
}