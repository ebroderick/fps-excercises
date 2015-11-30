package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0324TestSuite extends FunSuite {
  test("hasSubsequence") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(1)
    assert(Exercise0324.hasSubsequence(l1, l2))

    val l3 = List(2, 3)
    assert(Exercise0324.hasSubsequence(l1, l3))

    val l4 = List(100, 200)
    assert(!Exercise0324.hasSubsequence(l1, l4))

    val l5 = List(1, 1, 1, 1, 2, 3)
    val l6 = List(1, 2)
    assert(Exercise0324.hasSubsequence(l5, l6))
  }

  test("hasSubsequence2") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(1)
    assert(Exercise0324.hasSubsequence2(l1, l2))

    val l3 = List(2, 3)
    assert(Exercise0324.hasSubsequence2(l1, l3))

    val l4 = List(100, 200)
    assert(!Exercise0324.hasSubsequence2(l1, l4))

    val l5 = List(1, 1, 1, 1, 2, 3)
    val l6 = List(1, 2)
    assert(Exercise0324.hasSubsequence2(l5, l6))
  }
}
