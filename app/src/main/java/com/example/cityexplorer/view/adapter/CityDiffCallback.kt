package com.example.cityexplorer.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.cityexplorer.data.model.City


class CityDiffCallback(
    private val oldList: List<City>,
    private val newList: List<City>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]._id == newList[newItemPosition]._id // Assuming id is unique
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}