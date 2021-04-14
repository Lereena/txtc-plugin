package com.github.lereena.txtcplugin.language

import com.intellij.openapi.fileTypes.LanguageFileType

object TXTCFileType : LanguageFileType(TXTCLanguage) {
    override fun getName() = "TXTC"

    override fun getDescription() = "TXTC files"

    override fun getDefaultExtension() = "txtc"

    override fun getIcon() = TXTCIcons.TXTC_FILE
}
