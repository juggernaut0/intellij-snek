package com.github.juggernaut0.snek.psi

import com.github.juggernaut0.snek.SnekFileType
import com.github.juggernaut0.snek.SnekLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.util.PsiTreeUtil

class SnekFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SnekLanguage) {
    override fun getFileType(): FileType {
        return SnekFileType
    }

    val imports: List<SnekImportFrom> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, SnekImportFrom::class.java)
    val decls: List<SnekDecl> get() = PsiTreeUtil.getChildrenOfTypeAsList(this, SnekDecl::class.java)
    val callExpr: SnekCallExpr? get() = findChildByClass(SnekCallExpr::class.java)

    override fun toString(): String {
        return "Snek File"
    }
}