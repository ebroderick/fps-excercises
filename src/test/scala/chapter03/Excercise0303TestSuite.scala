package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0303TestSuite extends FunSuite {
  test("setHead example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0303.setHead(20, list) == Cons(20, Cons(2, Cons(3, Nil))))
  }

}