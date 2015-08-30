package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0320TestSuite extends FunSuite {

  test("flatMap") {
    val list = List(1, 3, 5)
    assert(Exercise0320.flatMap(list)(a => List(a, a + 1)) == List(1, 2, 3, 4, 5, 6))
  }
}