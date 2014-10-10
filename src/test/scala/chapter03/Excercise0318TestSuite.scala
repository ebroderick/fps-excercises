package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0318TestSuite extends FunSuite {
  test("map example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))
    assert(Excercise0318.map(list)(_ * 2) == Cons(2, Cons(4, Cons(6, Nil))))
  }
}