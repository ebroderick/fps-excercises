package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0404TestSuite extends FunSuite {
  test("map2 example") {
    assert(Excercise0404.sequence(List(Some(1), None)) == None)
    assert(Excercise0404.sequence(List(Some(1), Some(2))) == Some(List(1, 2)))
    assert(Excercise0404.sequence(List(Some(1), None, Some(3))) == None)
  }
}