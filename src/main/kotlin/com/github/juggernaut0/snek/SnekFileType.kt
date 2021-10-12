package com.github.juggernaut0.snek

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object SnekFileType: LanguageFileType(SnekLanguage) {
    override fun getName(): String = "Snek"
    override fun getDescription(): String = "Snek language file"
    override fun getDefaultExtension(): String = "snek"
    override fun getIcon(): Icon? = null
}
