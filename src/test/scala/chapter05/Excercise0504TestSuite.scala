package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0504TestSuite extends FunSuite {
  test("Stream.forAll example") {
    assert(Excercise0504.Stream(1, 2, 3, 4, 5).forAll(i => { println(s"checking $i"); i > 5 }) == false)
    assert(Excercise0504.Stream(1, 2, 3, 4, 5).forAll(i => { println(s"checking $i"); i > 0 }) == true)
  }
}