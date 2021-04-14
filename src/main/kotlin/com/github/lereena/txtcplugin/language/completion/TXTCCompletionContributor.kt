package com.github.lereena.txtcplugin.language.completion

import com.github.lereena.txtcplugin.language.TXTCTokenTypes
import com.intellij.codeInsight.completion.*
import com.intellij.patterns.PlatformPatterns

class TXTCCompletionContributor : CompletionContributor() {

    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(TXTCTokenTypes.TXTC),
            TXTCCompletionProvider()
        )
    }
}