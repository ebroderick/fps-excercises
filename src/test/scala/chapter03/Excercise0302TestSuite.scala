package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0302TestSuite extends FunSuite {
  test("tail example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0302.tail(list) == Cons(2, Cons(3, Nil)))
  }

}