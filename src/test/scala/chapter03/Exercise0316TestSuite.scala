package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0316TestSuite extends FunSuite {
  test("add1") {
    val l1 = List(1, 2, 3, 4)
    assert(Exercise0316.add1(l1) == List(2, 3, 4, 5))
  }
}
