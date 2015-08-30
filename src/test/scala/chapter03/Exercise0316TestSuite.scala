package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0316TestSuite extends FunSuite {

  test("add1") {
    val list = List(1, 2, 3)
    assert(Exercise0316.add1(list) == List(2, 3, 4))
  }
}