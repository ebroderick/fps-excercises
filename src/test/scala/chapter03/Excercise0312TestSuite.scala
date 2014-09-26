package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0312TestSuite extends FunSuite {
  test("reverse example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0312.reverse(list) == Cons(3, Cons(2, Cons(1, Nil))))
  }
}