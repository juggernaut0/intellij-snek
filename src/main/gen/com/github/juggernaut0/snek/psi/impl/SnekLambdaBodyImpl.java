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

public class SnekLambdaBodyImpl extends ASTWrapperPsiElement implements SnekLambdaBody {

  public SnekLambdaBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull SnekVisitor visitor) {
    visitor.visitLambdaBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof SnekVisitor) accept((SnekVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<SnekBinding> getBindingList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SnekBinding.class);
  }

  @Override
  @NotNull
  public List<SnekExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, SnekExpr.class);
  }

}
