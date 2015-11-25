package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0203TestSuite extends FunSuite {
  test("testCurry") {
    val f1 = Exercise0203.curry((a: Int, b: Int) => a + b)
    val f2 = f1(3)

    assert(f2(10) == 13)
  }
}