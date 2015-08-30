package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0312TestSuite extends FunSuite {

  test("reverse") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0312.reverse(list) == List(5, 4, 3, 2, 1))
  }
}