package com.github.lereena.txtcplugin.dataStructures

import java.io.File

class TrieNode(var key: Char?, var parent: TrieNode?) {

    val children: HashMap<Char, TrieNode> = HashMap()

    var isTerminating = false
}

class Trie() {

    private val root = TrieNode(key = null, parent = null)

    private fun insert(list: List<Char>) {
        var current = root

        list.forEach { element ->
            if (current.children[element] == null) {
                current.children[element] = TrieNode(element, current)
            }
            current = current.children[element]!!
        }

        current.isTerminating = true
    }

    private fun contains(list: List<Char>): Boolean {
        var current = root

        list.forEach { element ->
            val child = current.children[element] ?: return false
            current = child
        }

        return current.isTerminating
    }

    private fun collections(prefix: List<Char>, node: TrieNode?): List<List<Char>> {
        val results = mutableListOf<List<Char>>()

        if (node?.isTerminating == true) {
            results.add(prefix)
        }

        node?.children?.forEach { (key, node) ->
            results.addAll(collections(prefix + key, node))
        }

        return results
    }

    private fun collections(prefix: List<Char>): List<String> {
        var current = root

        prefix.forEach { element ->
            val child = current.children[element] ?: return emptyList()
            current = child
        }

        return collections(prefix, current).map { x -> x.joinToString("") }
    }

    fun insert(string: String) {
        insert(string.toList())
    }

    fun insertAll(list: List<String>) {
        list.forEach { word -> insert(word) }
    }

    fun contains(string: String): Boolean {
        return contains(string.toList())
    }

    fun collections(prefix: String): List<String> {
        return collections(prefix.toList())
    }

    fun initializeFromFile(path: String) {
        File(path).forEachLine { if (it.length >= 2) insert(it) }
    }
}
