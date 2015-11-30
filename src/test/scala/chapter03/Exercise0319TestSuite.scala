package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0319TestSuite extends FunSuite {
  test("filter") {
    val l1 = List(1, 2, 3, 4)
    assert(Exercise0319.filter(l1)(_ % 2 == 0) == List(2, 4))
  }
}
