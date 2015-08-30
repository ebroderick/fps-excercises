package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0203TestSuite extends FunSuite {

  test("curry") {
    val f: (Int, Int) => Int = (x, y) => x + y
    val f2 = Exercise0203.curry(f)
    val f3 = f2(2)
    val result = f3(6)
    assert(result == 8)
  }

}