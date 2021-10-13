package com.github.juggernaut0.snek;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.juggernaut0.snek.psi.SnekTypes;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.juggernaut0.snek.psi.SnekTypes.*;

%%

%{
  public SnekLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class SnekLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+
IDENT_START=[_a-zA-Z]
IDENT_CONTINUE=[_a-zA-Z0-9]
STRING_CONTENTS=[^\"\'\\]
END_OF_LINE_COMMENT="#"[^\r\n]*
STRING_CONTENTS=[^\"\'\\]|\\.

%state STRING

%%
<YYINITIAL> {
  {WHITE_SPACE}      { return WHITE_SPACE; }

  {END_OF_LINE_COMMENT} { return COMMENT; }

  "import"           { return IMPORT; }
  "from"             { return FROM; }
  "public"           { return PUBLIC; }
  "let"              { return LET; }
  "type"             { return TYPE; }
  "namespace"        { return NAMESPACE; }
  "new"              { return NEW; }

  "("                { return L_PAREN; }
  ")"                { return R_PAREN; }
  "{"                { return L_CURLY; }
  "}"                { return R_CURLY; }
  ","                { return COMMA; }
  ":"                { return COLON; }
  "_"                { return UNDERSCORE; }
  "["                { return L_SQUARE; }
  "]"                { return R_SQUARE; }
  "->"               { return ARROW; }
  "."                { return DOT; }
  "+"                { return PLUS; }
  "-"                { return MINUS; }
  "*"                { return TIMES; }
  "/"                { return DIV; }
  "<="               { return LEQ; }
  "<"                { return LT; }
  ">="               { return GEQ; }
  ">"                { return GT; }
  "=="               { return EQ; }
  "!="               { return NEQ; }
  "&&"               { return AND; }
  "||"               { return OR; }
  "="                { return EQUALS; }
  "!"                { return BANG; }
  "|"                { return BAR; }

  "true"             { return TRUE; }
  "false"            { return FALSE; }

  {IDENT_START}{IDENT_CONTINUE}* { return IDENT; }
  \d+(\.\d+)?        { return NUMBER; }
  "\""{STRING_CONTENTS}*"\""                      { return SnekTypes.STRING; }
  "\'"{STRING_CONTENTS}*"\'"                      { return SnekTypes.STRING; }
}

[^] { return BAD_CHARACTER; }
