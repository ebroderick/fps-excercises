package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0510TestSuite extends FunSuite {
  test("Stream.fibs  example") {
    assert(Excercise0510.Stream.fibs.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
  }
}