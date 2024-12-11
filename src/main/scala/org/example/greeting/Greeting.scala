package org.example.greeting

// does not contain or import any macros
object Greeting:
  def greet(name: Option[String] = None): String =
    name.map(n => s"Hello, ${n}!").getOrElse("Hello, world!")
