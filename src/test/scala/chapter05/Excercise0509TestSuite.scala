package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0509TestSuite extends FunSuite {
  test("Stream.from  example") {
    assert(Excercise0509.Stream.from(2).take(3).toList == List(2, 3, 4))
  }
}