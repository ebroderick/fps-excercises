package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0508TestSuite extends FunSuite {
  test("Stream.constant  example") {
    assert(Excercise0508.Stream.constant("x").take(3).toList == List("x", "x", "x"))
  }
}