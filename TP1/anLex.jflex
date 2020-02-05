%%

%public
%class Lexer
%unicode
%line
%column
%debug
%type Token

%yylexthrow{
Exception
%yylexthrow}

blank = [ \n\t\r]
int = -?[1-9][0-9]* | 0
op = "+" | "-"
avancer = [aA]vancer
tourner = [tT]ourner
ecrire = [eE]crire
lire = [lL]ire

%%

";"				{return new Token(Sym.PV);}
"("				{return new Token(Sym.LPAR);}
")"				{return new Token(Sym.RPAR);}
{op}			{return new OpToken(Sym.OP, yytext().charAt(0));}
{int}			{return new IntToken(Sym.INT, Integer.parseInt(yytext()));}
{avancer}		{return new InstructionToken(Sym.AVANCER, yytext());}
{tourner}		{return new InstructionToken(Sym.TOURNER, yytext());}
{ecrire}		{return new InstructionToken(Sym.ECRIRE, yytext());}
{lire}			{return new InstructionToken(Sym.LIRE, yytext());}
{blank}			{}
<<EOF>>			{return new Token(Sym.EOF);}
[^]				{throw new Exception("Lexer error\nLine : " + yyline + "\nColomn : " + yycolumn + "\ntext : " + yytext());}