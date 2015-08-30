package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0315TestSuite extends FunSuite {

  test("concat") {
    val list1 = List(1, 2)
    val list2 = List(3, 4)
    assert(Exercise0315.concat(List(list1, list2)) == List(1, 2, 3, 4))
  }
}