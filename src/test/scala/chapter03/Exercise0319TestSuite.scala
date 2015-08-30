package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0319TestSuite extends FunSuite {

  test("filter") {
    val list = List(1, 2, 3)
    assert(Exercise0319.filter(list)(_ != 1) == List(2, 3))
  }
}