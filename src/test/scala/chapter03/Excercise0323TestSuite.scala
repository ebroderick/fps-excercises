package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0323TestSuite extends FunSuite {
  test("zipwith example") {
    val list1 = Cons(1, Cons(2, Cons(3, Nil)))
    val list2 = Cons(4, Cons(5, Cons(6, Nil)))

    assert(Excercise0323.zipWith(list1, list2)((a1, a2) => a1 + a2) == Cons(5, Cons(7, Cons(9, Nil))))
  }
}