package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0503TestSuite extends FunSuite {
  test("Stream.take while example") {
    assert(Excercise0503.Stream(1, 2, 3, 4, 5).takeWhile(_ < 3).toList == List(1, 2))
  }
}