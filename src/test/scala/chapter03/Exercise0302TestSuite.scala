package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0302TestSuite extends FunSuite {

  test("tail") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0302.tail(list) == List(2, 3, 4, 5))
    assert(Exercise0302.tail(Nil) == Nil)
  }

}