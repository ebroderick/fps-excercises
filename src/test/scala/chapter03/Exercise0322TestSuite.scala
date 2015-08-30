package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0322TestSuite extends FunSuite {

  test("addCorrespondingElements") {
    val list1 = List(1, 2, 3)
    val list2 = List(3, 4, 5)
    assert(Exercise0322.addCorrespondingElements(list1, list2) == List(4, 6, 8))

    val list3 = List(1, 2)
    val list4 = List(3, 4, 5)
    assert(Exercise0322.addCorrespondingElements(list3, list4) == List(4, 6))

    val list5 = List(1, 2, 3)
    val list6 = List(3, 4)
    assert(Exercise0322.addCorrespondingElements(list5, list6) == List(4, 6))
  }

  test("addCorrespondingElements2") {
    val list1 = List(1, 2, 3)
    val list2 = List(3, 4, 5)
    assert(Exercise0322.addCorrespondingElements2(list1, list2) == List(4, 6, 8))

    val list3 = List(1, 2)
    val list4 = List(3, 4, 5)
    assert(Exercise0322.addCorrespondingElements2(list3, list4) == List(4, 6))

    val list5 = List(1, 2, 3)
    val list6 = List(3, 4)
    assert(Exercise0322.addCorrespondingElements2(list5, list6) == List(4, 6))
  }
}