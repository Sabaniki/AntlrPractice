package saba.antlr.practice

import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker

fun main() {
    val lexer = ExprLexer(CharStreams.fromString("3+2*4"))
    val stream = CommonTokenStream(lexer)
    val exprParser = ExprParser(stream)
    val expr: ExprParser.ExprContext = exprParser.expr()
    println("toInfoString : " + expr.toInfoString(exprParser))
    println("toString : $expr")
    println("toStringTree : " + expr.toStringTree())
    println("\n")
    // AST はこういう形で辿れる
    val term: List<ExprParser.TermContext> = expr.term()
    println(term[0].factor(0).INT())
    // ビジターパターンで処理することも可能
    val walker = ParseTreeWalker()
    walker.walk(ExprBaseListener(), expr)
}

