package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0304TestSuite extends FunSuite {

  test("drop") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0304.drop(list, 2) == List(3, 4, 5))
    assert(Exercise0304.drop(list, 5) == Nil)
    assert(Exercise0304.drop(Nil, 2) == Nil)
    assert(Exercise0304.drop(list, 0) == list)
  }

}