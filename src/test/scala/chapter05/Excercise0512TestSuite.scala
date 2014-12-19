package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0512TestSuite extends FunSuite {
  test("Stream.fibs with unfold  example") {
    assert(Excercise0512.Stream.fibs.take(10).toList == List(0, 1, 1, 2, 3, 5, 8, 13, 21, 34))
  }

  test("Stream.from with unfold example") {
    assert(Excercise0512.Stream.from(2).take(3).toList == List(2, 3, 4))
  }

  test("Stream.constant with unfold example") {
    assert(Excercise0512.Stream.constant("x").take(3).toList == List("x", "x", "x"))
  }

  test("Stream.ones with unfold example") {
    assert(Excercise0512.Stream.ones.take(3).toList == List(1, 1, 1))
  }
}