package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0501TestSuite extends FunSuite {
  test("Stream.toList example") {
    assert(Excercise0501.Stream(1, 2, 3, 4, 5).toList == List(1, 2, 3, 4, 5))

  }
}