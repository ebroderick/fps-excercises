package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0306TestSuite extends FunSuite {

  test("init") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0306.init(list) == List(1, 2, 3, 4))
  }

}