package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0324TestSuite extends FunSuite {

  test("hasSubsequence") {
    val list1 = List(1, 2, 3)
    assert(Exercise0324.hasSubsequence(list1, List(1, 2)))
    assert(Exercise0324.hasSubsequence(list1, List(2, 3)))
    assert(!Exercise0324.hasSubsequence(list1, List(1, 1)))

    val list2 = List(1, 2, 3, 1, 2, 1, 2, 3, 4, 1, 2)
    assert(Exercise0324.hasSubsequence(list2, List(1, 2, 3, 4)))
    assert(Exercise0324.hasSubsequence(list2, List(1, 2)))
    assert(Exercise0324.hasSubsequence(list2, List(3, 1, 2)))
    assert(!Exercise0324.hasSubsequence(list1, List(8)))
  }
}