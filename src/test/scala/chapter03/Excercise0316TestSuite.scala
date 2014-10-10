package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0316TestSuite extends FunSuite {
  test("add 1 example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))
    assert(Excercise0316.add1(list) == Cons(2, Cons(3, Cons(4, Nil))))
  }
}