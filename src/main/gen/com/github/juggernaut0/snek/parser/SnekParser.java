// This is a generated file. Not intended for manual editing.
package com.github.juggernaut0.snek.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.juggernaut0.snek.psi.SnekTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SnekParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return snekFile(b, l + 1);
  }

  /* ********************************************************** */
  // L_PAREN unary_expr (binary_op unary_expr)+ R_PAREN
  public static boolean binary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expr")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && unary_expr(b, l + 1);
    r = r && binary_expr_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, BINARY_EXPR, r);
    return r;
  }

  // (binary_op unary_expr)+
  private static boolean binary_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expr_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_expr_2_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!binary_expr_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "binary_expr_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // binary_op unary_expr
  private static boolean binary_expr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_expr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binary_op(b, l + 1);
    r = r && unary_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | TIMES | DIV | AND | OR | LT | GT | LEQ | GEQ | EQ | NEQ
  public static boolean binary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binary_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_OP, "<binary op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, TIMES);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, LEQ);
    if (!r) r = consumeToken(b, GEQ);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NEQ);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LET pattern EQUALS expr
  public static boolean binding(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binding")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, BINDING, null);
    r = consumeToken(b, LET);
    p = r; // pin = 1
    r = r && report_error_(b, pattern(b, l + 1));
    r = p && report_error_(b, consumeToken(b, EQUALS)) && r;
    r = p && expr(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // L_PAREN (DOT | expr) expr* R_PAREN
  public static boolean call_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && call_expr_1(b, l + 1);
    r = r && call_expr_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, CALL_EXPR, r);
    return r;
  }

  // DOT | expr
  private static boolean call_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr_1")) return false;
    boolean r;
    r = consumeToken(b, DOT);
    if (!r) r = expr(b, l + 1);
    return r;
  }

  // expr*
  private static boolean call_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_expr_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "call_expr_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NUMBER | STRING | TRUE | FALSE | L_PAREN R_PAREN
  public static boolean const_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "const_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONST_LITERAL, "<const literal>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = parseTokens(b, 0, L_PAREN, R_PAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PUBLIC? (namespace_decl | type_decl | binding)
  public static boolean decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECL, "<decl>");
    r = decl_0(b, l + 1);
    r = r && decl_1(b, l + 1);
    exit_section_(b, l, m, r, false, SnekParser::recover);
    return r;
  }

  // PUBLIC?
  private static boolean decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_0")) return false;
    consumeToken(b, PUBLIC);
    return true;
  }

  // namespace_decl | type_decl | binding
  private static boolean decl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_1")) return false;
    boolean r;
    r = namespace_decl(b, l + 1);
    if (!r) r = type_decl(b, l + 1);
    if (!r) r = binding(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY decl* R_CURLY
  public static boolean decl_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_block")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECL_BLOCK, null);
    r = consumeToken(b, L_CURLY);
    p = r; // pin = 1
    r = r && report_error_(b, decl_block_1(b, l + 1));
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // decl*
  private static boolean decl_block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decl_block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "decl_block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // L_CURLY field_pattern (COMMA field_pattern)* COMMA? R_CURLY type_annotation?
  public static boolean destr_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "destr_pattern")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && field_pattern(b, l + 1);
    r = r && destr_pattern_2(b, l + 1);
    r = r && destr_pattern_3(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    r = r && destr_pattern_5(b, l + 1);
    exit_section_(b, m, DESTR_PATTERN, r);
    return r;
  }

  // (COMMA field_pattern)*
  private static boolean destr_pattern_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "destr_pattern_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!destr_pattern_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "destr_pattern_2", c)) break;
    }
    return true;
  }

  // COMMA field_pattern
  private static boolean destr_pattern_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "destr_pattern_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && field_pattern(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean destr_pattern_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "destr_pattern_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // type_annotation?
  private static boolean destr_pattern_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "destr_pattern_5")) return false;
    type_annotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // const_literal | binary_expr | call_expr | new_expr | lambda_expr | qname
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = const_literal(b, l + 1);
    if (!r) r = binary_expr(b, l + 1);
    if (!r) r = call_expr(b, l + 1);
    if (!r) r = new_expr(b, l + 1);
    if (!r) r = lambda_expr(b, l + 1);
    if (!r) r = qname(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENT COLON expr
  public static boolean field_init(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_init")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && expr(b, l + 1);
    exit_section_(b, m, FIELD_INIT, r);
    return r;
  }

  /* ********************************************************** */
  // field_init (COMMA field_init)* COMMA?
  public static boolean field_init_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_init_list")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = field_init(b, l + 1);
    r = r && field_init_list_1(b, l + 1);
    r = r && field_init_list_2(b, l + 1);
    exit_section_(b, m, FIELD_INIT_LIST, r);
    return r;
  }

  // (COMMA field_init)*
  private static boolean field_init_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_init_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field_init_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "field_init_list_1", c)) break;
    }
    return true;
  }

  // COMMA field_init
  private static boolean field_init_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_init_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && field_init(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean field_init_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_init_list_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // name_pattern | (LET pattern EQUALS IDENT)
  public static boolean field_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_pattern")) return false;
    if (!nextTokenIs(b, "<field pattern>", IDENT, LET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_PATTERN, "<field pattern>");
    r = name_pattern(b, l + 1);
    if (!r) r = field_pattern_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LET pattern EQUALS IDENT
  private static boolean field_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_pattern_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && pattern(b, l + 1);
    r = r && consumeTokens(b, 0, EQUALS, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY type_params? type_name* ARROW type_name R_CURLY
  public static boolean func_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_type")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && func_type_1(b, l + 1);
    r = r && func_type_2(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && type_name(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, FUNC_TYPE, r);
    return r;
  }

  // type_params?
  private static boolean func_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_type_1")) return false;
    type_params(b, l + 1);
    return true;
  }

  // type_name*
  private static boolean func_type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_type_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_name(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "func_type_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IMPORT qname* FROM STRING
  public static boolean import_from(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_from")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && import_from_1(b, l + 1);
    r = r && consumeTokens(b, 0, FROM, STRING);
    exit_section_(b, m, IMPORT_FROM, r);
    return r;
  }

  // qname*
  private static boolean import_from_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_from_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qname(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_from_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (binding* expr)+
  public static boolean lambda_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA_BODY, "<lambda body>");
    r = lambda_body_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!lambda_body_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_body", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // binding* expr
  private static boolean lambda_body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_body_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lambda_body_0_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // binding*
  private static boolean lambda_body_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_body_0_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!binding(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_body_0_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // L_CURLY pattern* ARROW lambda_body R_CURLY
  public static boolean lambda_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LAMBDA_EXPR, null);
    r = consumeToken(b, L_CURLY);
    p = r; // pin = 1
    r = r && report_error_(b, lambda_expr_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, ARROW)) && r;
    r = p && report_error_(b, lambda_body(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // pattern*
  private static boolean lambda_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambda_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "lambda_expr_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // L_SQUARE pattern* R_SQUARE
  public static boolean list_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_pattern")) return false;
    if (!nextTokenIs(b, L_SQUARE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_SQUARE);
    r = r && list_pattern_1(b, l + 1);
    r = r && consumeToken(b, R_SQUARE);
    exit_section_(b, m, LIST_PATTERN, r);
    return r;
  }

  // pattern*
  private static boolean list_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "list_pattern_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!pattern(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "list_pattern_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENT type_annotation?
  public static boolean name_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "name_pattern")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && name_pattern_1(b, l + 1);
    exit_section_(b, m, NAME_PATTERN, r);
    return r;
  }

  // type_annotation?
  private static boolean name_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "name_pattern_1")) return false;
    type_annotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // qname (LT type_name+ GT)?
  public static boolean named_type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_type")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = qname(b, l + 1);
    r = r && named_type_1(b, l + 1);
    exit_section_(b, m, NAMED_TYPE, r);
    return r;
  }

  // (LT type_name+ GT)?
  private static boolean named_type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_type_1")) return false;
    named_type_1_0(b, l + 1);
    return true;
  }

  // LT type_name+ GT
  private static boolean named_type_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_type_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && named_type_1_0_1(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, null, r);
    return r;
  }

  // type_name+
  private static boolean named_type_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "named_type_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = type_name(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!type_name(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "named_type_1_0_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NAMESPACE qname decl_block
  public static boolean namespace_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namespace_decl")) return false;
    if (!nextTokenIs(b, NAMESPACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NAMESPACE_DECL, null);
    r = consumeToken(b, NAMESPACE);
    p = r; // pin = 1
    r = r && report_error_(b, qname(b, l + 1));
    r = p && decl_block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // NEW named_type? L_CURLY field_init_list? R_CURLY
  public static boolean new_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_expr")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, NEW_EXPR, null);
    r = consumeToken(b, NEW);
    p = r; // pin = 1
    r = r && report_error_(b, new_expr_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, L_CURLY)) && r;
    r = p && report_error_(b, new_expr_3(b, l + 1)) && r;
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // named_type?
  private static boolean new_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_expr_1")) return false;
    named_type(b, l + 1);
    return true;
  }

  // field_init_list?
  private static boolean new_expr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "new_expr_3")) return false;
    field_init_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // const_literal | wildcard_pattern | name_pattern | list_pattern | destr_pattern
  public static boolean pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "pattern")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATTERN, "<pattern>");
    r = const_literal(b, l + 1);
    if (!r) r = wildcard_pattern(b, l + 1);
    if (!r) r = name_pattern(b, l + 1);
    if (!r) r = list_pattern(b, l + 1);
    if (!r) r = destr_pattern(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENT (DOT IDENT)*
  public static boolean qname(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qname")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && qname_1(b, l + 1);
    exit_section_(b, m, QNAME, r);
    return r;
  }

  // (DOT IDENT)*
  private static boolean qname_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qname_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!qname_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "qname_1", c)) break;
    }
    return true;
  }

  // DOT IDENT
  private static boolean qname_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "qname_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // !(PUBLIC | LET | TYPE | NAMESPACE | L_PAREN | R_CURLY)
  static boolean recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUBLIC | LET | TYPE | NAMESPACE | L_PAREN | R_CURLY
  private static boolean recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_0")) return false;
    boolean r;
    r = consumeToken(b, PUBLIC);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, TYPE);
    if (!r) r = consumeToken(b, NAMESPACE);
    if (!r) r = consumeToken(b, L_PAREN);
    if (!r) r = consumeToken(b, R_CURLY);
    return r;
  }

  /* ********************************************************** */
  // import_from* decl* call_expr?
  static boolean snekFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snekFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = snekFile_0(b, l + 1);
    r = r && snekFile_1(b, l + 1);
    r = r && snekFile_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // import_from*
  private static boolean snekFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snekFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_from(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snekFile_0", c)) break;
    }
    return true;
  }

  // decl*
  private static boolean snekFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snekFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!decl(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "snekFile_1", c)) break;
    }
    return true;
  }

  // call_expr?
  private static boolean snekFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "snekFile_2")) return false;
    call_expr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // COLON type_name
  public static boolean type_annotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_annotation")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && type_name(b, l + 1);
    exit_section_(b, m, TYPE_ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // type_case_decl | type_name
  public static boolean type_case(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_case")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_CASE, "<type case>");
    r = type_case_decl(b, l + 1);
    if (!r) r = type_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PUBLIC? IDENT type_fields
  public static boolean type_case_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_case_decl")) return false;
    if (!nextTokenIs(b, "<type case decl>", IDENT, PUBLIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_CASE_DECL, "<type case decl>");
    r = type_case_decl_0(b, l + 1);
    r = r && consumeToken(b, IDENT);
    r = r && type_fields(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUBLIC?
  private static boolean type_case_decl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_case_decl_0")) return false;
    consumeToken(b, PUBLIC);
    return true;
  }

  /* ********************************************************** */
  // EQUALS type_case (BAR type_case)*
  public static boolean type_cases(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_cases")) return false;
    if (!nextTokenIs(b, EQUALS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQUALS);
    r = r && type_case(b, l + 1);
    r = r && type_cases_2(b, l + 1);
    exit_section_(b, m, TYPE_CASES, r);
    return r;
  }

  // (BAR type_case)*
  private static boolean type_cases_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_cases_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_cases_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_cases_2", c)) break;
    }
    return true;
  }

  // BAR type_case
  private static boolean type_cases_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_cases_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BAR);
    r = r && type_case(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE type_decl_name (type_cases | type_fields)?
  public static boolean type_decl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DECL, null);
    r = consumeToken(b, TYPE);
    p = r; // pin = 1
    r = r && report_error_(b, type_decl_name(b, l + 1));
    r = p && type_decl_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (type_cases | type_fields)?
  private static boolean type_decl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_2")) return false;
    type_decl_2_0(b, l + 1);
    return true;
  }

  // type_cases | type_fields
  private static boolean type_decl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_2_0")) return false;
    boolean r;
    r = type_cases(b, l + 1);
    if (!r) r = type_fields(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // IDENT type_params?
  public static boolean type_decl_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_name")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && type_decl_name_1(b, l + 1);
    exit_section_(b, m, TYPE_DECL_NAME, r);
    return r;
  }

  // type_params?
  private static boolean type_decl_name_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_decl_name_1")) return false;
    type_params(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PUBLIC? IDENT COLON type_name
  public static boolean type_field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_field")) return false;
    if (!nextTokenIs(b, "<type field>", IDENT, PUBLIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_FIELD, "<type field>");
    r = type_field_0(b, l + 1);
    r = r && consumeTokens(b, 0, IDENT, COLON);
    r = r && type_name(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PUBLIC?
  private static boolean type_field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_field_0")) return false;
    consumeToken(b, PUBLIC);
    return true;
  }

  /* ********************************************************** */
  // type_field (COMMA type_field)* COMMA?
  public static boolean type_field_list(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_field_list")) return false;
    if (!nextTokenIs(b, "<type field list>", IDENT, PUBLIC)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_FIELD_LIST, "<type field list>");
    r = type_field(b, l + 1);
    r = r && type_field_list_1(b, l + 1);
    r = r && type_field_list_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA type_field)*
  private static boolean type_field_list_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_field_list_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!type_field_list_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "type_field_list_1", c)) break;
    }
    return true;
  }

  // COMMA type_field
  private static boolean type_field_list_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_field_list_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && type_field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean type_field_list_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_field_list_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // L_CURLY type_field_list? R_CURLY
  public static boolean type_fields(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_fields")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && type_fields_1(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, TYPE_FIELDS, r);
    return r;
  }

  // type_field_list?
  private static boolean type_fields_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_fields_1")) return false;
    type_field_list(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // named_type | func_type | L_PAREN R_PAREN | TIMES | BANG | UNDERSCORE
  public static boolean type_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_name")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_NAME, "<type name>");
    r = named_type(b, l + 1);
    if (!r) r = func_type(b, l + 1);
    if (!r) r = parseTokens(b, 0, L_PAREN, R_PAREN);
    if (!r) r = consumeToken(b, TIMES);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, UNDERSCORE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LT IDENT+ GT
  public static boolean type_params(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params")) return false;
    if (!nextTokenIs(b, LT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LT);
    r = r && type_params_1(b, l + 1);
    r = r && consumeToken(b, GT);
    exit_section_(b, m, TYPE_PARAMS, r);
    return r;
  }

  // IDENT+
  private static boolean type_params_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_params_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, IDENT)) break;
      if (!empty_element_parsed_guard_(b, "type_params_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // unary_op* expr
  public static boolean unary_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPR, "<unary expr>");
    r = unary_expr_0(b, l + 1);
    r = r && expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // unary_op*
  private static boolean unary_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_expr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!unary_op(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "unary_expr_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // PLUS | MINUS | BANG
  public static boolean unary_op(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_op")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OP, "<unary op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BANG);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // UNDERSCORE type_annotation?
  public static boolean wildcard_pattern(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wildcard_pattern")) return false;
    if (!nextTokenIs(b, UNDERSCORE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNDERSCORE);
    r = r && wildcard_pattern_1(b, l + 1);
    exit_section_(b, m, WILDCARD_PATTERN, r);
    return r;
  }

  // type_annotation?
  private static boolean wildcard_pattern_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "wildcard_pattern_1")) return false;
    type_annotation(b, l + 1);
    return true;
  }

}
