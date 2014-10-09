package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0315TestSuite extends FunSuite {
  test("concat lists example") {
    val list1 = Cons(1, Cons(2, Nil))
    val list2 = Cons(3, Cons(4, Nil))
    val list3 = Cons(5, Cons(6, Nil))

    val listOfLists = Cons(list1, Cons(list2, Cons(list3, Nil)))
    assert(Excercise0315.concatLists(listOfLists) == Cons(1, Cons(2, Cons(3, Cons(4, Cons(5, Cons(6, Nil)))))))

  }
}