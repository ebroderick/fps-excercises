package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0317TestSuite extends FunSuite {
  test("doubleToString") {
    val l1 = List(1.0, 2.0, 3.0, 4.2)
    assert(Exercise0317.doubleToString(l1) == List("1.0", "2.0", "3.0", "4.2"))

  }
}
