package com.github.lereena.txtcplugin.language.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.completion.PrioritizedLookupElement
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.progress.ProgressManager
import com.intellij.util.ProcessingContext

class TXTCCompletionProvider : CompletionProvider<CompletionParameters>() {

    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val prefix = result.prefixMatcher.prefix
        if (prefix.isEmpty())
            return

        for (word in CompletionSource.getCompletions(prefix)) {
            ProgressManager.checkCanceled()

            val frequency = CompletionSource.getFrequency(word)

            val element = PrioritizedLookupElement.withPriority(
                LookupElementBuilder.create(word).withTypeText(frequency.toString()),
                    frequency!!.toDouble())

            result.withPrefixMatcher(prefix).addElement(element)
        }
    }
}