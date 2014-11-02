package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0502TestSuite extends FunSuite {
  test("Stream.take example") {
    assert(Excercise0502.Stream(1, 2, 3, 4, 5).take(2).toList == List(1, 2))
    assert(Excercise0502.Stream(1, 2, 3, 4, 5).take(0).toList == List())
    assert(Excercise0502.Stream().take(3).toList == List())
    assert(Excercise0502.Stream(1).take(1).toList == List(1))
  }

  test("Stream.drop example") {
    assert(Excercise0502.Stream(1, 2, 3, 4, 5).drop(2).toList == List(3, 4, 5))
    assert(Excercise0502.Stream(1, 2, 3, 4, 5).drop(0).toList == List(1, 2, 3, 4, 5))
    assert(Excercise0502.Stream(1).drop(3).toList == List())
  }
}