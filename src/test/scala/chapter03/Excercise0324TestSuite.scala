package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0324TestSuite extends FunSuite {
  test("hasSubsequence example") {
    val list = Cons(1, Cons(2, Cons(3, Cons(4, Nil))))

    assert(Excercise0324.hasSubsequence(list, Cons(1, Cons(2, Nil))) == true)
    assert(Excercise0324.hasSubsequence(list, Cons(3, Cons(4, Nil))) == true)
    assert(Excercise0324.hasSubsequence(list, Cons(2, Cons(4, Nil))) == false)
    assert(Excercise0324.hasSubsequence(list, Cons(5, Nil)) == false)
  }
}