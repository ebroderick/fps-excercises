package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0506TestSuite extends FunSuite {
  test("Stream.headOption  example") {
    assert(Excercise0506.Stream(1, 2, 3, 4, 5).headOption() == Some(1))
    assert(Excercise0506.Stream().headOption() == None)
  }
}