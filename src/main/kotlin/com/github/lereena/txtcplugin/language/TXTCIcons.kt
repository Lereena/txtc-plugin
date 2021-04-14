package com.github.lereena.txtcplugin.language

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object TXTCIcons {
    val TXTC_FILE = load("/icons/txtc_file.svg")

    private fun load(path: String): Icon = IconLoader.getIcon(path, TXTCIcons::class.java)
}