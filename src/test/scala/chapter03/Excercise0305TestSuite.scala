package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0305TestSuite extends FunSuite {
  test("dropWhile example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0305.dropWhile(list, (i: Int) => i < 2) == Cons(2, Cons(3, Nil)))
    assert(Excercise0305.dropWhile(list, (i: Int) => i > 250) == list)
    assert(Excercise0305.dropWhile(list, (i: Int) => i > -1) == Nil)
  }

}