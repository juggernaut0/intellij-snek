package com.github.juggernaut0.snek;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.juggernaut0.snek.psi.SnekTypes;
import com.intellij.psi.TokenType;

%%

%class SnekLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
IDENT_START=[_a-zA-Z]
IDENT_CONTINUE=[_a-zA-Z0-9]
STRING_CONTENTS=[^\"\'\\]
END_OF_LINE_COMMENT="#"[^\r\n]*

%state STRING

%%

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return SnekTypes.COMMENT; }

<YYINITIAL> "public"                                        { yybegin(YYINITIAL); return SnekTypes.PUBLIC; }
<YYINITIAL> "let"                                           { yybegin(YYINITIAL); return SnekTypes.LET; }
<YYINITIAL> "="                                             { yybegin(YYINITIAL); return SnekTypes.EQUALS; }
<YYINITIAL> "("                                             { yybegin(YYINITIAL); return SnekTypes.L_PAREN; }
<YYINITIAL> ")"                                             { yybegin(YYINITIAL); return SnekTypes.R_PAREN; }

<YYINITIAL> {CRLF}({CRLF}|{WHITE_SPACE})+                   { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

<YYINITIAL> {IDENT_START}{IDENT_CONTINUE}*                  { yybegin(YYINITIAL); return SnekTypes.IDENT; }

<YYINITIAL> "\""{STRING_CONTENTS}*"\""                      { yybegin(YYINITIAL); return SnekTypes.STRING; }
<YYINITIAL> "\'"{STRING_CONTENTS}*"\'"                      { yybegin(YYINITIAL); return SnekTypes.STRING; }

({CRLF}|{WHITE_SPACE})+                                     { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

[^]                                                         { return TokenType.BAD_CHARACTER; }
