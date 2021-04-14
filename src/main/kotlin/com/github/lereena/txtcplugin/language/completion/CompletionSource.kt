package com.github.lereena.txtcplugin.language.completion

import com.github.lereena.txtcplugin.dataStructures.Trie

object CompletionSource {
    private val trie = Trie()
    private val frequencies = HashMap<String, Long>()

    fun load(path: String) {
        val text = javaClass.getResource(path).readText().split('\n')
        text.forEach {
            val splitLine = it.split('\t', ' ').filter { s -> s.isNotBlank() }
            val word = splitLine[0].trim()
            trie.insert(word)
            frequencies[word] = splitLine[1].toLong()
        }
    }

    fun getCompletions(prefix: String) = trie.collections(prefix)

    fun getFrequency(word: String) = frequencies[word]
}
