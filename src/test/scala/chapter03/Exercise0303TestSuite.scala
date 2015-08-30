package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0303TestSuite extends FunSuite {

  test("setHead") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0303.setHead(0, list) == List(0, 2, 3, 4, 5))
  }

}