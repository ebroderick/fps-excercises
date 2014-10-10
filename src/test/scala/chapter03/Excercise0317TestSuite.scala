package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0317TestSuite extends FunSuite {
  test("double to string example") {
    val list = Cons(1.0, Cons(2.0, Cons(3.0, Nil)))
    assert(Excercise0317.convertToString(list) == Cons("1.0", Cons("2.0", Cons("3.0", Nil))))
  }
}