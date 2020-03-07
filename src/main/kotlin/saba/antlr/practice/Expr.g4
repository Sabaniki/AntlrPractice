grammar Expr;

@header {
    package saba.antlr.practice;
}

prog: expr;
expr: term ((ADD|MIN) term)*;
term: factor ((MUL|DIV) factor)*;
factor: INT
    | LPAREN expr RPAREN
    ;
INT     : [0-9]+ ;
ADD: '+';
MIN: '-';
MUL: '*';
DIV: '/';
LPAREN: '(';
RPAREN: ')';
