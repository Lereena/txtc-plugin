package com.github.lereena.txtcplugin.language.completion

import com.intellij.openapi.progress.ProgressIndicator
import com.intellij.openapi.application.PreloadingActivity

class CompletionSourceLoader : PreloadingActivity() {
    override fun preload(indicator: ProgressIndicator) {
        CompletionSource.load("/corpus/google-10000-english.txt")
    }
}
