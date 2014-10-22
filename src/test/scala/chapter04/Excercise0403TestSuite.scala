package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0403TestSuite extends FunSuite {
  test("map2 example") {
    assert(Excercise0403.map2(Some(1), Some(2))((a, b) => a + b) == Some(3))
    assert(Excercise0403.map2(None, Some(2))((a, b) => b) == None)
    assert(Excercise0403.map2(None, None)((a, b) => b) == None)
    assert(Excercise0403.map2(Some(1), None)((a, b) => b) == None)
  }
}