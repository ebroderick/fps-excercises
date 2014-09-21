package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0311TestSuite extends FunSuite {
  test("sum with foldleft example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0311.sum(list) == 6)
    assert(Excercise0311.sum(Nil) == 0)
  }

  test("product with foldleft example") {
    val list = Cons(1.0, Cons(2.0, Cons(3.0, Nil)))

    assert(Excercise0311.product(list) == 6.0)
    assert(Excercise0311.product(Nil) == 1.0)
  }

  test("length with foldleft example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0311.length(list) == 3)
    assert(Excercise0311.length(Nil) == 0)
  }

}