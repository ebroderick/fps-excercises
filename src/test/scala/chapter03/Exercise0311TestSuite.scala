package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0311TestSuite extends FunSuite {

  test("foldLeftSum") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0311.foldLeftSum(list) == 15)
  }

  test("foldLeftProduct") {
    val list = List(1.0, 2.0, 3.0, 4.0, 5.0)
    assert(Exercise0311.foldLeftProduct(list) == 120)
  }

  test("foldLeftLength") {
    val list = List(1.0, 2.0, 3.0, 4.0, 5.0)
    assert(Exercise0311.foldLeftLength(list) == 5)
  }
}