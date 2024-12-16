package org.example.macros

import scala.quoted.{Expr, Quotes}

// contains macros
object Macros:
  // uncomment the next line (and comment the others) to switch to ordinary methods
  // def decorate(s: String): String = s">>> $s <<<"

  inline def decorate(inline s: String): String = ${ decorateQuotes('s) }
  def decorateQuotes(s: Expr[String])(using Quotes): Expr[String] = '{ ">>> " + $s + " <<<" }
