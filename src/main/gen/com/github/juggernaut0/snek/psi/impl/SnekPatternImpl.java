// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.juggernaut0.snek.psi.SnekTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.juggernaut0.snek.psi.*;

public class SnekPatternImpl extends ASTWrapperPsiElement implements SnekPattern {

  public SnekPatternImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SnekVisitor visitor) {
    visitor.visitPattern(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SnekVisitor) accept((SnekVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SnekConstLiteral getConstLiteral() {
    return findChildByClass(SnekConstLiteral.class);
  }

  @Override
  @Nullable
  public SnekDestrPattern getDestrPattern() {
    return findChildByClass(SnekDestrPattern.class);
  }

  @Override
  @Nullable
  public SnekListPattern getListPattern() {
    return findChildByClass(SnekListPattern.class);
  }

  @Override
  @Nullable
  public SnekNamePattern getNamePattern() {
    return findChildByClass(SnekNamePattern.class);
  }

  @Override
  @Nullable
  public SnekWildcardPattern getWildcardPattern() {
    return findChildByClass(SnekWildcardPattern.class);
  }

}
