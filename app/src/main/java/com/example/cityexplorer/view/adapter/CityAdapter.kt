package com.example.cityexplorer.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cityexplorer.data.model.City
import com.example.cityexplorer.databinding.CityItemBinding


class CityAdapter(
    private var cities: List<City>,
    private val onCityClickListener: OnCityClickListener
) : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    inner class CityViewHolder(private val binding: CityItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(city: City) {
            binding.title.text = "${city.name}, ${city.country}"
            binding.subtitle.text = "Lon: ${city.coord.lon}, Lat: ${city.coord.lat}"
            binding.root.setOnClickListener {
                onCityClickListener.onCityClick(city)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val binding = CityItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(binding)
    }

    override fun getItemCount() = cities.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        holder.bind(cities[position])
    }

    fun updateCities(newCities: List<City>) {
        val diffCallback = CityDiffCallback(cities, newCities)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        cities = newCities
        diffResult.dispatchUpdatesTo(this)
    }
}