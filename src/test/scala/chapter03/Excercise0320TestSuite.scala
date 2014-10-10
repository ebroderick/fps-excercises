package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0320TestSuite extends FunSuite {
  test("flapmap example") {
    val list = Cons(1, Cons(2, Nil))
    assert(Excercise0320.flatMap(list)(i => Cons(i, Cons(i, Nil))) == Cons(1, Cons(1, Cons(2, Cons(2, Nil)))))
  }
}