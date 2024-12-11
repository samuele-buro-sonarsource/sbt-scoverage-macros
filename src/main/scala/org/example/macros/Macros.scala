package org.example.macros

import scala.quoted.{Expr, Quotes}

// contains macros
object Macros:
  inline def decorate(inline s: String): String = ${ decorateQuotes('s) }
  def decorateQuotes(s: Expr[String])(using Quotes): Expr[String] = '{ ">>> " + $s + " <<<" }
