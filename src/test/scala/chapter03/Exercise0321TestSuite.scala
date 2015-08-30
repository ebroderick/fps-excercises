package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0321TestSuite extends FunSuite {

  test("filterWithFlatMap") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0321.filterWithFlatMap(list)(a => a > 2) == List(3, 4, 5))
  }
}