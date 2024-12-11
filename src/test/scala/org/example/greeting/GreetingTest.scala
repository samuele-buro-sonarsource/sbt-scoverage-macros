package org.example.greeting

import munit.ScalaCheckSuite
import org.example.greeting.Greeting.greet
import org.scalacheck.Prop.forAll

class GreetingTest extends ScalaCheckSuite:
  test("greet() == \"Hello, world!\"") {
    assertEquals(greet(), "Hello, world!")
  }

  test("forall name . greet(Some(name)) == s\"Hello, $name!\"") {
    forAll { (name: String) =>
      assertEquals(greet(Some(name)), s"Hello, $name!")
    }
  }
