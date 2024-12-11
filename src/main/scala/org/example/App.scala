package org.example

import org.example.greeting.Greeting.greet
import org.example.macros.Macros.decorate

// use macros
object App:
  def main(args: Array[String]): Unit =
    println(decorate(greet()))
