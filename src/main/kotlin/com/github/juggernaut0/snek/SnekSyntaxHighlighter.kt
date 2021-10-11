package com.github.juggernaut0.snek

import com.github.juggernaut0.snek.psi.SnekTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class SnekSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return SnekLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            SnekTypes.LET -> LET_KEYS
            SnekTypes.STRING -> STRING_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val LET = TextAttributesKey.createTextAttributesKey("SNEK_LET", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING = TextAttributesKey.createTextAttributesKey("SNEK_STRING", DefaultLanguageHighlighterColors.STRING)
        val COMMENT = TextAttributesKey.createTextAttributesKey("SNEK_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("SNEK_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val LET_KEYS = arrayOf(LET)
        private val STRING_KEYS = arrayOf(STRING)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}