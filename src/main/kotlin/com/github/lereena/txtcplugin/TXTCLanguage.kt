package com.github.lereena.txtcplugin

import com.intellij.lang.Language

object TXTCLanguage : Language("TXTC") {

    override fun isCaseSensitive() = false

    override fun getDisplayName() = "TXTC"
}
