package com.github.lereena.txtcplugin.language

import com.intellij.lang.Language

object TXTCLanguage : Language("TXTC") {

    override fun isCaseSensitive() = false

    override fun getDisplayName() = "TXTC"
}
