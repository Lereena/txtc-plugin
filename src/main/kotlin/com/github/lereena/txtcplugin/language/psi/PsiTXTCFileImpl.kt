package com.github.lereena.txtcplugin.language.psi

import com.github.lereena.txtcplugin.language.TXTCFileType
import com.github.lereena.txtcplugin.language.TXTCLanguage
import com.github.lereena.txtcplugin.language.TXTCTokenTypes
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.PsiFileImpl
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry

class PsiTXTCFileImpl(viewProvider: FileViewProvider) : PsiFileImpl(
    TXTCTokenTypes.TXTC_FILE,
    TXTCTokenTypes.TXTC_FILE, viewProvider
), PsiTXTCFile {
    private var myFileType: FileType? = null

    init {
        myFileType = if (viewProvider.baseLanguage !== TXTCLanguage) TXTCFileType else viewProvider.fileType
    }

    override fun accept(visitor: PsiElementVisitor) {
        visitor.visitTXTCFile(this)
    }

    override fun toString(): String {
        return "PsiFile(txtc):$name"
    }

    override fun getFileType(): FileType {
        return myFileType!!
    }

    override fun getReferences(): Array<PsiReference?> {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this)
    }

    private fun PsiElementVisitor.visitTXTCFile(file: PsiTXTCFile) {
        visitFile(file)
    }
}
