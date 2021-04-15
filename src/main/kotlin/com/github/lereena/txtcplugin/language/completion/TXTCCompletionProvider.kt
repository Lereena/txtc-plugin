package com.github.lereena.txtcplugin.language.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.CompletionSorter
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.progress.ProgressManager
import com.intellij.util.ProcessingContext

class TXTCCompletionProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(
            parameters: CompletionParameters, context: ProcessingContext, result: CompletionResultSet
    ) {
        val prefix = result.prefixMatcher.prefix

        if (prefix.isEmpty()) return

        val sorter = CompletionSorter.emptySorter().weigh(TXTCCompletionWeigher).weighBefore("liftShorter")

        for (word in CompletionSource.getCompletions(prefix)) {
            ProgressManager.checkCanceled()

            val frequency = CompletionSource.getFrequency(word)

            val element = LookupElementBuilder.create(word).withTypeText(frequency.toString())

            result.withRelevanceSorter(sorter).withPrefixMatcher(prefix).addElement(element)
        }
    }
}
