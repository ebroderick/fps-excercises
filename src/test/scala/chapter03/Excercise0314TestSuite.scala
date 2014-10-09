package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0314TestSuite extends FunSuite {
  test("append example") {
    val list1 = Cons(1, Cons(2, Nil))
    val list2 = Cons(3, Cons(4, Nil))

    assert(Excercise0314.append(list1, list2) == Cons(1, Cons(2, Cons(3, Cons(4, Nil)))))

    val list3 = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))
    val list4 = Nil

    assert(Excercise0314.append(list3, list4) == Cons(1, Cons(2, Cons(3, Cons(4, Nil)))))
  }
}