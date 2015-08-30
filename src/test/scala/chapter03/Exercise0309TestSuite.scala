package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0309TestSuite extends FunSuite {

  test("length") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0309.length(list) == 5)
  }

}