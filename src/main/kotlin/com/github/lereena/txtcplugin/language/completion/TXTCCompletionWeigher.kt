package com.github.lereena.txtcplugin.language.completion

import com.intellij.codeInsight.lookup.LookupElement
import com.intellij.codeInsight.lookup.LookupElementWeigher

object TXTCCompletionWeigher : LookupElementWeigher("frequency", true, false) {
    override fun weigh(element: LookupElement): Comparable<*> {
        return CompletionSource.getFrequency(element.lookupString)!!
    }
}
