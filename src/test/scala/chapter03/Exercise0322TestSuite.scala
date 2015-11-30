package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0322TestSuite extends FunSuite {
  test("sumLists") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(1, 1, 1, 1)
    assert(Exercise0322.sumLists(l1, l2) == List(2, 3, 4, 5))
  }

  test("sumLists2") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(1, 1, 1, 1)
    assert(Exercise0322.sumLists2(l1, l2) == List(2, 3, 4, 5))
  }
}
