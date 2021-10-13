// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface SnekPattern extends PsiElement {

  @Nullable
  SnekConstLiteral getConstLiteral();

  @Nullable
  SnekDestrPattern getDestrPattern();

  @Nullable
  SnekListPattern getListPattern();

  @Nullable
  SnekNamePattern getNamePattern();

  @Nullable
  SnekWildcardPattern getWildcardPattern();

}
