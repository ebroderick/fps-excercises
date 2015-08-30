package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0314TestSuite extends FunSuite {

  test("append") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0314.append(list, 6) == List(1, 2, 3, 4, 5, 6))
  }
}