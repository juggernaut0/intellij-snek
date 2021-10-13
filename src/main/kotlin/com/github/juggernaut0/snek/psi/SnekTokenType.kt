package com.github.juggernaut0.snek.psi

import com.github.juggernaut0.snek.SnekLanguage
import com.intellij.psi.tree.IElementType

class SnekTokenType(debugName: String) : IElementType(debugName, SnekLanguage) {
    override fun toString(): String {
        return "SnekTokenType.${super.toString()}"
    }
}
