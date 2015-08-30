package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0323TestSuite extends FunSuite {

  test("zipWith") {
    val list1 = List(1, 2, 3)
    val list2 = List(3, 4, 5)
    assert(Exercise0323.zipWith(list1, list2)((a, b) => b - a) == List(2, 2, 2))

    val list3 = List(1, 2, 3)
    val list4 = List(1.0, 2.0, 3,0)
    assert(Exercise0323.zipWith(list3, list4)((a, b) => a.toString + b.toString) == List("11.0", "22.0", "33.0"))
  }
}