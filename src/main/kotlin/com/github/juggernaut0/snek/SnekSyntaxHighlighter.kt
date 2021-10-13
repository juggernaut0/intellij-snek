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
            SnekTypes.LET, SnekTypes.PUBLIC, SnekTypes.IMPORT, SnekTypes.TYPE, SnekTypes.NAMESPACE, SnekTypes.FROM, SnekTypes.NEW -> KEYWORD_KEYS
            SnekTypes.TRUE, SnekTypes.FALSE -> BOOL_KEYS
            SnekTypes.NUMBER -> NUMBER_KEYS
            SnekTypes.STRING -> STRING_KEYS
            SnekTypes.COMMENT -> COMMENT_KEYS
            TokenType.BAD_CHARACTER -> BAD_CHAR_KEYS
            else -> EMPTY_KEYS
        }
    }

    companion object {
        val KEYWORD = TextAttributesKey.createTextAttributesKey("SNEK_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val STRING = TextAttributesKey.createTextAttributesKey("SNEK_STRING", DefaultLanguageHighlighterColors.STRING)
        val NUMBER = TextAttributesKey.createTextAttributesKey("SNEK_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val COMMENT = TextAttributesKey.createTextAttributesKey("SNEK_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
        val BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("SNEK_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

        private val KEYWORD_KEYS = arrayOf(KEYWORD)
        private val STRING_KEYS = arrayOf(STRING)
        private val BOOL_KEYS = arrayOf(KEYWORD)
        private val NUMBER_KEYS = arrayOf(NUMBER)
        private val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER)
        private val COMMENT_KEYS = arrayOf(COMMENT)
        private val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
}