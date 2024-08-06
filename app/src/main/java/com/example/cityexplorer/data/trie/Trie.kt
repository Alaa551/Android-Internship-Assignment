package com.example.cityexplorer.data.trie

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.cityexplorer.data.model.City

class Trie {

    private val root = TrieNode()

    @RequiresApi(Build.VERSION_CODES.N)
    fun insert(city: City) {
        var node = root
        val key = "${city.name.lowercase()}, ${city.country.lowercase()}"
        for (char in key) {
            node = node.children.computeIfAbsent(char) { TrieNode() }
        }
        node.isEndOfWord = true
        node.city = city
    }

    fun search(prefix: String): List<City> {
        var node = root
        val lowerPrefix = prefix.lowercase()
        for (char in lowerPrefix) {
            node = node.children[char] ?: return emptyList()
        }
        return collectWords(node)
    }

    private fun collectWords(node: TrieNode): List<City> {
        val result = mutableListOf<City>()
        if (node.isEndOfWord) {
            node.city?.let { result.add(it) }
        }
        for (child in node.children.values) {
            result.addAll(collectWords(child))
        }
        return result
    }


}
