package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0315TestSuite extends FunSuite {
  test("concat") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(5, 6)
    val l3 = List(l1, l2)
    assert(Exercise0315.concat(l3) == List(1, 2, 3, 4, 5, 6))
  }
}
