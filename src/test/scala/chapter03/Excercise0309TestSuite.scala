package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0309TestSuite extends FunSuite {
  test("count with fold example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0309.length(list) == 3)
    assert(Excercise0309.length(Nil) == 0)
  }

}