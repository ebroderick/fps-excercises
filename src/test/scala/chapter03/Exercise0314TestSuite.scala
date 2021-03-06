package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0314TestSuite extends FunSuite {
  test("append") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(5, 6)
    assert(Exercise0314.append(l1, l2) == List(1, 2, 3, 4, 5, 6))
  }
}
