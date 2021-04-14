package com.github.lereena.txtcplugin.language

import com.github.lereena.txtcplugin.language.psi.PsiTXTCFileImpl
import com.intellij.lang.ASTFactory
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.EmptyLexer
import com.intellij.lexer.Lexer
import com.intellij.openapi.fileTypes.PlainTextFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.PsiUtilCore
import java.lang.UnsupportedOperationException

class TXTCParserDefinition : ParserDefinition {
    private val TXTC_FILE_ELEMENT_TYPE: IFileElementType =
        object : IFileElementType(PlainTextFileType.INSTANCE.language) {
            override fun parseContents(chameleon: ASTNode): ASTNode {
                val chars = chameleon.chars
                return ASTFactory.leaf(TXTCTokenTypes.TXTC, chars)
            }
        }

    override fun createLexer(project: Project?): Lexer {
        return EmptyLexer()
    }

    override fun createParser(project: Project?): PsiParser {
        throw UnsupportedOperationException("Not supported")
    }

    override fun getFileNodeType(): IFileElementType {
        return TXTC_FILE_ELEMENT_TYPE
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return PsiUtilCore.NULL_PSI_ELEMENT
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return PsiTXTCFileImpl(viewProvider)
    }
}
