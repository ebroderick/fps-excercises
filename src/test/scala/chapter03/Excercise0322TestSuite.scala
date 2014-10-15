package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0322TestSuite extends FunSuite {
  test("combine example") {
    val list1 = Cons(1, Cons(2, Cons(3, Nil)))
    val list2 = Cons(4, Cons(5, Cons(6, Nil)))

    assert(Excercise0322.combine(list1, list2) == Cons(5, Cons(7, Cons(9, Nil))))
  }
}