package org.example

import munit.ScalaCheckSuite
import org.example.NumUtils.isEven
import org.scalacheck.Prop.forAll

class NumUtilsTest extends ScalaCheckSuite:
  test("forall n . isEven(2n) and !isEven(2n + 1)") {
    forAll { (n: Int) =>
      assert(isEven(2 * n))
      assert(!isEven(2 * n + 1))
    }
  }
