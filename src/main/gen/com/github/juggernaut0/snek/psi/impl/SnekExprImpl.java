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

public class SnekExprImpl extends ASTWrapperPsiElement implements SnekExpr {

  public SnekExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SnekVisitor visitor) {
    visitor.visitExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SnekVisitor) accept((SnekVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public SnekBinaryExpr getBinaryExpr() {
    return findChildByClass(SnekBinaryExpr.class);
  }

  @Override
  @Nullable
  public SnekCallExpr getCallExpr() {
    return findChildByClass(SnekCallExpr.class);
  }

  @Override
  @Nullable
  public SnekConstLiteral getConstLiteral() {
    return findChildByClass(SnekConstLiteral.class);
  }

  @Override
  @Nullable
  public SnekLambdaExpr getLambdaExpr() {
    return findChildByClass(SnekLambdaExpr.class);
  }

  @Override
  @Nullable
  public SnekNewExpr getNewExpr() {
    return findChildByClass(SnekNewExpr.class);
  }

  @Override
  @Nullable
  public SnekQname getQname() {
    return findChildByClass(SnekQname.class);
  }

}
