package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0321TestSuite extends FunSuite {
  test("filter with flatMap example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))
    assert(Excercise0321.filter(list)(_ >= 2) == Cons(2, Cons(3, Nil)))
  }
}