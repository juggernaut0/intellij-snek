// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class SnekVisitor extends PsiElementVisitor {

  public void visitBinding(@NotNull SnekBinding o) {
    visitPsiElement(o);
  }

  public void visitCallExpr(@NotNull SnekCallExpr o) {
    visitPsiElement(o);
  }

  public void visitDecl(@NotNull SnekDecl o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull SnekExpr o) {
    visitPsiElement(o);
  }

  public void visitPattern(@NotNull SnekPattern o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
