// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.juggernaut0.snek.psi.impl.*;

public interface SnekTypes {

  IElementType BINARY_EXPR = new SnekElementType("BINARY_EXPR");
  IElementType BINARY_OP = new SnekElementType("BINARY_OP");
  IElementType BINDING = new SnekElementType("BINDING");
  IElementType CALL_EXPR = new SnekElementType("CALL_EXPR");
  IElementType CONST_LITERAL = new SnekElementType("CONST_LITERAL");
  IElementType DECL = new SnekElementType("DECL");
  IElementType DECL_BLOCK = new SnekElementType("DECL_BLOCK");
  IElementType DESTR_PATTERN = new SnekElementType("DESTR_PATTERN");
  IElementType EXPR = new SnekElementType("EXPR");
  IElementType FIELD_INIT = new SnekElementType("FIELD_INIT");
  IElementType FIELD_INIT_LIST = new SnekElementType("FIELD_INIT_LIST");
  IElementType FIELD_PATTERN = new SnekElementType("FIELD_PATTERN");
  IElementType FUNC_TYPE = new SnekElementType("FUNC_TYPE");
  IElementType IMPORT_FROM = new SnekElementType("IMPORT_FROM");
  IElementType LAMBDA_BODY = new SnekElementType("LAMBDA_BODY");
  IElementType LAMBDA_EXPR = new SnekElementType("LAMBDA_EXPR");
  IElementType LIST_PATTERN = new SnekElementType("LIST_PATTERN");
  IElementType NAMED_TYPE = new SnekElementType("NAMED_TYPE");
  IElementType NAMESPACE_DECL = new SnekElementType("NAMESPACE_DECL");
  IElementType NAME_PATTERN = new SnekElementType("NAME_PATTERN");
  IElementType NEW_EXPR = new SnekElementType("NEW_EXPR");
  IElementType PATTERN = new SnekElementType("PATTERN");
  IElementType QNAME = new SnekElementType("QNAME");
  IElementType TYPE_ANNOTATION = new SnekElementType("TYPE_ANNOTATION");
  IElementType TYPE_CASE = new SnekElementType("TYPE_CASE");
  IElementType TYPE_CASES = new SnekElementType("TYPE_CASES");
  IElementType TYPE_CASE_DECL = new SnekElementType("TYPE_CASE_DECL");
  IElementType TYPE_DECL = new SnekElementType("TYPE_DECL");
  IElementType TYPE_DECL_NAME = new SnekElementType("TYPE_DECL_NAME");
  IElementType TYPE_FIELD = new SnekElementType("TYPE_FIELD");
  IElementType TYPE_FIELDS = new SnekElementType("TYPE_FIELDS");
  IElementType TYPE_FIELD_LIST = new SnekElementType("TYPE_FIELD_LIST");
  IElementType TYPE_NAME = new SnekElementType("TYPE_NAME");
  IElementType TYPE_PARAMS = new SnekElementType("TYPE_PARAMS");
  IElementType UNARY_EXPR = new SnekElementType("UNARY_EXPR");
  IElementType UNARY_OP = new SnekElementType("UNARY_OP");
  IElementType WILDCARD_PATTERN = new SnekElementType("WILDCARD_PATTERN");

  IElementType AND = new SnekTokenType("AND");
  IElementType ARROW = new SnekTokenType("ARROW");
  IElementType BANG = new SnekTokenType("BANG");
  IElementType BAR = new SnekTokenType("BAR");
  IElementType COLON = new SnekTokenType("COLON");
  IElementType COMMA = new SnekTokenType("COMMA");
  IElementType COMMENT = new SnekTokenType("COMMENT");
  IElementType DIV = new SnekTokenType("DIV");
  IElementType DOT = new SnekTokenType("DOT");
  IElementType EQ = new SnekTokenType("EQ");
  IElementType EQUALS = new SnekTokenType("EQUALS");
  IElementType FALSE = new SnekTokenType("FALSE");
  IElementType FROM = new SnekTokenType("FROM");
  IElementType GEQ = new SnekTokenType("GEQ");
  IElementType GT = new SnekTokenType("GT");
  IElementType IDENT = new SnekTokenType("IDENT");
  IElementType IMPORT = new SnekTokenType("IMPORT");
  IElementType LEQ = new SnekTokenType("LEQ");
  IElementType LET = new SnekTokenType("LET");
  IElementType LT = new SnekTokenType("LT");
  IElementType L_CURLY = new SnekTokenType("L_CURLY");
  IElementType L_PAREN = new SnekTokenType("L_PAREN");
  IElementType L_SQUARE = new SnekTokenType("L_SQUARE");
  IElementType MINUS = new SnekTokenType("MINUS");
  IElementType NAMESPACE = new SnekTokenType("NAMESPACE");
  IElementType NEQ = new SnekTokenType("NEQ");
  IElementType NEW = new SnekTokenType("NEW");
  IElementType NUMBER = new SnekTokenType("NUMBER");
  IElementType OR = new SnekTokenType("OR");
  IElementType PLUS = new SnekTokenType("PLUS");
  IElementType PUBLIC = new SnekTokenType("PUBLIC");
  IElementType R_CURLY = new SnekTokenType("R_CURLY");
  IElementType R_PAREN = new SnekTokenType("R_PAREN");
  IElementType R_SQUARE = new SnekTokenType("R_SQUARE");
  IElementType STRING = new SnekTokenType("STRING");
  IElementType TIMES = new SnekTokenType("TIMES");
  IElementType TRUE = new SnekTokenType("TRUE");
  IElementType TYPE = new SnekTokenType("TYPE");
  IElementType UNDERSCORE = new SnekTokenType("UNDERSCORE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BINARY_EXPR) {
        return new SnekBinaryExprImpl(node);
      }
      else if (type == BINARY_OP) {
        return new SnekBinaryOpImpl(node);
      }
      else if (type == BINDING) {
        return new SnekBindingImpl(node);
      }
      else if (type == CALL_EXPR) {
        return new SnekCallExprImpl(node);
      }
      else if (type == CONST_LITERAL) {
        return new SnekConstLiteralImpl(node);
      }
      else if (type == DECL) {
        return new SnekDeclImpl(node);
      }
      else if (type == DECL_BLOCK) {
        return new SnekDeclBlockImpl(node);
      }
      else if (type == DESTR_PATTERN) {
        return new SnekDestrPatternImpl(node);
      }
      else if (type == EXPR) {
        return new SnekExprImpl(node);
      }
      else if (type == FIELD_INIT) {
        return new SnekFieldInitImpl(node);
      }
      else if (type == FIELD_INIT_LIST) {
        return new SnekFieldInitListImpl(node);
      }
      else if (type == FIELD_PATTERN) {
        return new SnekFieldPatternImpl(node);
      }
      else if (type == FUNC_TYPE) {
        return new SnekFuncTypeImpl(node);
      }
      else if (type == IMPORT_FROM) {
        return new SnekImportFromImpl(node);
      }
      else if (type == LAMBDA_BODY) {
        return new SnekLambdaBodyImpl(node);
      }
      else if (type == LAMBDA_EXPR) {
        return new SnekLambdaExprImpl(node);
      }
      else if (type == LIST_PATTERN) {
        return new SnekListPatternImpl(node);
      }
      else if (type == NAMED_TYPE) {
        return new SnekNamedTypeImpl(node);
      }
      else if (type == NAMESPACE_DECL) {
        return new SnekNamespaceDeclImpl(node);
      }
      else if (type == NAME_PATTERN) {
        return new SnekNamePatternImpl(node);
      }
      else if (type == NEW_EXPR) {
        return new SnekNewExprImpl(node);
      }
      else if (type == PATTERN) {
        return new SnekPatternImpl(node);
      }
      else if (type == QNAME) {
        return new SnekQnameImpl(node);
      }
      else if (type == TYPE_ANNOTATION) {
        return new SnekTypeAnnotationImpl(node);
      }
      else if (type == TYPE_CASE) {
        return new SnekTypeCaseImpl(node);
      }
      else if (type == TYPE_CASES) {
        return new SnekTypeCasesImpl(node);
      }
      else if (type == TYPE_CASE_DECL) {
        return new SnekTypeCaseDeclImpl(node);
      }
      else if (type == TYPE_DECL) {
        return new SnekTypeDeclImpl(node);
      }
      else if (type == TYPE_DECL_NAME) {
        return new SnekTypeDeclNameImpl(node);
      }
      else if (type == TYPE_FIELD) {
        return new SnekTypeFieldImpl(node);
      }
      else if (type == TYPE_FIELDS) {
        return new SnekTypeFieldsImpl(node);
      }
      else if (type == TYPE_FIELD_LIST) {
        return new SnekTypeFieldListImpl(node);
      }
      else if (type == TYPE_NAME) {
        return new SnekTypeNameImpl(node);
      }
      else if (type == TYPE_PARAMS) {
        return new SnekTypeParamsImpl(node);
      }
      else if (type == UNARY_EXPR) {
        return new SnekUnaryExprImpl(node);
      }
      else if (type == UNARY_OP) {
        return new SnekUnaryOpImpl(node);
      }
      else if (type == WILDCARD_PATTERN) {
        return new SnekWildcardPatternImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
