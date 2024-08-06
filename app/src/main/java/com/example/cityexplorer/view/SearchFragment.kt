package com.example.cityexplorer.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cityexplorer.R
import com.example.cityexplorer.data.model.City
import com.example.cityexplorer.databinding.FragmentSearchBinding
import com.example.cityexplorer.view.adapter.CityAdapter
import com.example.cityexplorer.view.adapter.OnCityClickListener
import com.example.cityexplorer.viewmodel.CityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : Fragment(), OnCityClickListener {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: CityViewModel by viewModels()
    private lateinit var cityAdapter: CityAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        cityAdapter = CityAdapter(emptyList(), this)
        binding.searchRv.layoutManager = LinearLayoutManager(requireContext())
        binding.searchRv.adapter = cityAdapter

        viewModel.filteredCities.observe(this) { cities ->
            cityAdapter.updateCities(cities)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.filterCities(query ?: "")
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                CoroutineScope(Dispatchers.IO).launch {
                    viewModel.filterCities(newText ?: "")
                }
                return true
            }
        })

    }

    override fun onCityClick(city: City) {
        val intentUri =
            Uri.parse("geo:${city.coord.lat},${city.coord.lon}?q=${city.coord.lat},${city.coord.lon}(${city.name})")
        val mapIntent = Intent(Intent.ACTION_VIEW, intentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        startActivity(mapIntent)
    }
}



