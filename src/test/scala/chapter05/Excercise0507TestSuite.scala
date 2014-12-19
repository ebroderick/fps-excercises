package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0507TestSuite extends FunSuite {
  test("Stream.map  example") {
    assert(Excercise0507.Stream(1, 2, 3).map(_ + 1).toList == List(2, 3, 4))
  }

  test("Stream.filter example") {
    assert(Excercise0507.Stream(1, 2, 3).filter(_ > 1).toList == List(2, 3))
  }

  test("Stream.append example") {
    assert(Excercise0507.Stream(1, 2, 3).append(Excercise0507.Stream(4, 5)).toList == List(1, 2, 3, 4, 5))
  }

  test("Stream.flatMap example") {
    assert(Excercise0507.Stream(1, 2, 3).flatMap(a => Excercise0507.Stream(a, a)).toList == List(1, 1, 2, 2, 3, 3))
  }
}