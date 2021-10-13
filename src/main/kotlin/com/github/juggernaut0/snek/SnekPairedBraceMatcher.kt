package com.github.juggernaut0.snek

import com.github.juggernaut0.snek.psi.SnekTypes
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class SnekPairedBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean = true

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }

    private companion object {
        val PAIRS = arrayOf(
            BracePair(SnekTypes.L_CURLY, SnekTypes.R_CURLY, true),
            BracePair(SnekTypes.L_PAREN, SnekTypes.R_PAREN, true),
            BracePair(SnekTypes.L_SQUARE, SnekTypes.R_SQUARE, true),
            BracePair(SnekTypes.LT, SnekTypes.GT, false),
        )
    }
}