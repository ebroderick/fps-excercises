package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0514TestSuite extends FunSuite {
  test("Stream.startsWith example") {
    assert(Excercise0514.Stream(1, 2, 3).startsWith(Excercise0514.Stream(1)) == true)
    assert(Excercise0514.Stream(1, 2, 3).startsWith(Excercise0514.Stream(4)) == false)
  }
}