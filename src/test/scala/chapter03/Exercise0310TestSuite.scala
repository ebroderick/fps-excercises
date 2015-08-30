package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0310TestSuite extends FunSuite {

  test("foldLeft") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0310.foldLeft(list, 0)((b, a) => b + 1) == 5)
  }

}