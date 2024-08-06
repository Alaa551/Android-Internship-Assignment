package com.example.cityexplorer.data.trie

import com.example.cityexplorer.data.model.City

class TrieNode {
    val children: MutableMap<Char, TrieNode> = mutableMapOf()
    var isEndOfWord: Boolean = false
    var city: City? = null
}
