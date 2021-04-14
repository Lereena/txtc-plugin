package com.github.lereena.txtcplugin.language

import com.intellij.lang.ASTFactory
import com.intellij.lang.ASTNode
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType

object TXTCTokenTypes {

    val TXTC_FILE: IElementType = object : IFileElementType("TXTC_FILE", TXTCLanguage) {
        override fun parseContents(chameleon: ASTNode): ASTNode {
            return ASTFactory.leaf(TXTC, chameleon.chars)
        }
    }

    val TXTC = IFileElementType("TXTC_FILE", TXTCLanguage)
}
