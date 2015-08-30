package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0204TestSuite extends FunSuite {

  test("uncurry") {
    val f: (Int, Int) => Int = (x, y) => x + y
    val f2 = Exercise0203.curry(f)
    val f3 = Exercise0204.uncurry(f2)
    val result = f3(2, 6)
    assert(result == 8)
  }

}