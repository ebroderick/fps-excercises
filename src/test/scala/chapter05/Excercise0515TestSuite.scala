package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0515TestSuite extends FunSuite {
  test("Stream.tails example") {
    val stream = Excercise0515.Stream(1, 2, 3)
    val tails = stream.tails

    assert(tails.map(_.toList).toList == List(List(1, 2, 3), List(2, 3), List(3)))
  }
}