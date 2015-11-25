package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0204TestSuite extends FunSuite {
  test("testUncurry") {
    val f1 = Exercise0203.curry((a: Int, b: Int) => a + b)
    val f2 = Exercise0204.uncurry(f1)

    assert(f2(3, 10) == 13)
  }
}