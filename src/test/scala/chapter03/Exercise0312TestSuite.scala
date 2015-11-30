package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0312TestSuite extends FunSuite {
  test("reverse") {
    val l = List(1, 2, 3, 4)
    assert(Exercise0312.reverse(l) == List(4, 3, 2, 1))
  }
}
