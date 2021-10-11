// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SnekExpr extends PsiElement {

  @Nullable
  SnekCallExpr getCallExpr();

  @Nullable
  SnekConstLiteral getConstLiteral();

  @Nullable
  SnekLambdaExpr getLambdaExpr();

  @Nullable
  SnekNewExpr getNewExpr();

  @Nullable
  SnekQname getQname();

}
