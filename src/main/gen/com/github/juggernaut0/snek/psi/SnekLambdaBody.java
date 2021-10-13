// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SnekLambdaBody extends PsiElement {

  @NotNull
  List<SnekBinding> getBindingList();

  @NotNull
  List<SnekExpr> getExprList();

}
