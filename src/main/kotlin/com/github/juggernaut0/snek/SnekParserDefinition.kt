package com.github.juggernaut0.snek

import com.github.juggernaut0.snek.parser.SnekParser
import com.github.juggernaut0.snek.psi.SnekFile
import com.github.juggernaut0.snek.psi.SnekTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class SnekParserDefinition : ParserDefinition {
  override fun createLexer(project: Project): Lexer {
    return SnekLexerAdapter()
  }

  override fun getWhitespaceTokens(): TokenSet {
    return WHITE_SPACES
  }

  override fun getCommentTokens(): TokenSet {
    return COMMENTS
  }

  override fun getStringLiteralElements(): TokenSet {
    return STRINGS
  }

  override fun createParser(project: Project): PsiParser {
    return SnekParser()
  }

  override fun getFileNodeType(): IFileElementType {
    return FILE
  }

  override fun createFile(viewProvider: FileViewProvider): PsiFile {
    return SnekFile(viewProvider)
  }

  override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
    return SpaceRequirements.MAY
  }

  override fun createElement(node: ASTNode): PsiElement {
    return SnekTypes.Factory.createElement(node)
  }

  companion object {
    val WHITE_SPACES = TokenSet.create(TokenType.WHITE_SPACE)
    val COMMENTS = TokenSet.create(SnekTypes.COMMENT)
    val STRINGS = TokenSet.create(SnekTypes.STRING)
    val FILE = IFileElementType(SnekLanguage)
  }
}
