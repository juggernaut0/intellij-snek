package com.github.juggernaut0.snek

import com.intellij.formatting.*

class SnekFormattingModelBuilder : FormattingModelBuilder {
    override fun createModel(formattingContext: FormattingContext): FormattingModel {
        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            SnekBlock(formattingContext.psiElement, formattingContext.codeStyleSettings, alignment = Alignment.createAlignment()),
            formattingContext.codeStyleSettings,
        )
    }
}
