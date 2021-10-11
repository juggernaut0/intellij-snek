package com.github.juggernaut0.snek.psi

import com.github.juggernaut0.snek.SnekFileType
import com.github.juggernaut0.snek.SnekLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class SimpleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, SnekLanguage) {
    override fun getFileType(): FileType {
        return SnekFileType
    }

    override fun toString(): String {
        return "Snek File"
    }
}