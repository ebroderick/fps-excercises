package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0317TestSuite extends FunSuite {

  test("doubleToString") {
    val list = List(1.0, 2.0, 3.0)
    assert(Exercise0317.doubleToString(list) == List("1.0", "2.0", "3.0"))
  }
}