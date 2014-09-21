package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0306TestSuite extends FunSuite {
  test("init example") {
    val list = Cons(1, Cons(2, Cons(3, Nil)))

    assert(Excercise0306.init(list) == Cons(1, Cons(2, Nil)))
  }

}