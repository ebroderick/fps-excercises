package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0304TestSuite extends FunSuite {
  test("drop example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0304.drop(list, 1) == Cons(2, Cons(3, Nil)))
    assert(Excercise0304.drop(list, 2) == Cons(3, Nil))
    assert(Excercise0304.drop(Nil, 2) == Nil)
    assert(Excercise0304.drop(list, 0) == list)
  }

}