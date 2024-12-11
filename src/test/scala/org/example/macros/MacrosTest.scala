package org.example.macros

import munit.ScalaCheckSuite
import org.example.macros.Macros.decorate
import org.scalacheck.Prop.forAll

class MacrosTest extends ScalaCheckSuite:
  test("forall s . decorate(s) == s\">>> $s <<<\"") {
    forAll { (s: String) =>
      assertEquals(decorate(s), s">>> $s <<<")
    }
  }
