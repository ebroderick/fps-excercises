package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0202TestSuite extends FunSuite {
  test("isSorted") {
    assert(Excercise0202.isSorted(Array(0, 1, 2, 5, 7), (x: Int, y: Int) => x < y) == true)
    assert(Excercise0202.isSorted(Array(7, 1, 2, 5, 7), (x: Int, y: Int) => x < y) == false)
    assert(Excercise0202.isSorted(Array(0, 1, 2, 5, 7, 6), (x: Int, y: Int) => x < y) == false)
  }
}