// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.juggernaut0.snek.psi.impl.*;

public interface SnekTypes {

  IElementType BINDING = new SnekElementType("BINDING");
  IElementType CALL_EXPR = new SnekElementType("CALL_EXPR");
  IElementType DECL = new SnekElementType("DECL");
  IElementType EXPR = new SnekElementType("EXPR");
  IElementType PATTERN = new SnekElementType("PATTERN");

  IElementType EQUALS = new SnekTokenType("EQUALS");
  IElementType IDENT = new SnekTokenType("IDENT");
  IElementType LET = new SnekTokenType("LET");
  IElementType L_PAREN = new SnekTokenType("L_PAREN");
  IElementType R_PAREN = new SnekTokenType("R_PAREN");
  IElementType STRING = new SnekTokenType("STRING");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BINDING) {
        return new SnekBindingImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new SnekCallExprImpl(node);
      }
      else if (type == DECL) {
        return new SnekDeclImpl(node);
      }
      else if (type == EXPR) {
        return new SnekExprImpl(node);
      }
      else if (type == PATTERN) {
        return new SnekPatternImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
