package com.github.juggernaut0.snek

import com.github.juggernaut0.snek.psi.*
import com.intellij.formatting.*
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock
import com.intellij.psi.tree.IElementType

class SnekBlock(
    psi: PsiElement,
    private val settings: CodeStyleSettings,
    wrap: Wrap? = null,
    alignment: Alignment? = null,
    private val indent: Indent? = null,
    childIndent: Indent? = null,
    private val spacing: SpacingBuilder? = null,
) : AbstractBlock(psi.node, wrap, alignment) {
    private val _childIndent = childIndent

    override fun getIndent(): Indent {
        return indent ?: Indent.getNoneIndent()
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {
        return spacing?.getSpacing(this, child1, child2)
    }

    override fun isLeaf(): Boolean {
        return node.firstChildNode == null
    }

    override fun buildChildren(): List<Block> {
        return SnekBlockVisitor(settings).also { node.psi.accept(it) }.getBlocks()
    }

    override fun getChildIndent(): Indent? = _childIndent ?: Indent.getNoneIndent()

    override fun getDebugName(): String? {
        return node.psi?.javaClass?.simpleName
    }
}

class SnekBlockVisitor(private val settings: CodeStyleSettings) : SnekVisitor() {
    private val blocks = mutableListOf<Block>()
    private var alignment: Alignment? = null

    fun getBlocks(): List<Block> = blocks

    private fun addBlock(
        psi: PsiElement?,
        wrap: Wrap? = null,
        indent: Indent? = null,
        childIndent: Indent? = null,
        spacing: SpacingBuilder? = null,
    ) {
        if (psi == null) return
        blocks.add(SnekBlock(psi, settings, wrap, alignment, indent, childIndent, spacing))
    }

    override fun visitFile(file: PsiFile) {
        super.visitFile(file)
        if (file !is SnekFile) return
        withAlignment {
            for (import in file.imports) {
                addBlock(import)
            }
            for (decl in file.decls) {
                addBlock(decl)
            }
            addBlock(file.callExpr)
        }
    }

    override fun visitDecl(o: SnekDecl) {
        super.visitDecl(o)
        addBlock(o.findChildByType(SnekTypes.PUBLIC))
        addBlock(o.binding)
        addBlock(o.typeDecl)
        addBlock(o.namespaceDecl, spacing = SpacingBuilder(settings, SnekLanguage).around(SnekTypes.QNAME).spaces(1))
    }

    override fun visitNamespaceDecl(o: SnekNamespaceDecl) {
        super.visitNamespaceDecl(o)
        addBlock(o.findChildByType(SnekTypes.NAMESPACE))
        addBlock(o.qname)
        addBlock(o.declBlock, childIndent = Indent.getNormalIndent())
    }

    override fun visitDeclBlock(o: SnekDeclBlock) {
        super.visitDeclBlock(o)
        addBlock(o.findChildByType(SnekTypes.L_CURLY))
        withAlignment {
            for (decl in o.declList) {
                addBlock(decl, indent = Indent.getNormalIndent())
            }
        }
        addBlock(o.findChildByType(SnekTypes.R_CURLY))
    }

    private fun PsiElement.findChildByType(type: IElementType) = node.findChildByType(type)?.psi
    private inline fun withAlignment(block: () -> Unit) {
        alignment = Alignment.createAlignment()
        block()
        alignment = null
    }
}
