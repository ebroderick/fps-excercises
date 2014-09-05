package chapter02

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0201TestSuite extends FunSuite {
  test("fibonacci numbers") {
    assert(Excercise0201.fib(0) == 0)
    assert(Excercise0201.fib(1) == 1)
    assert(Excercise0201.fib(2) == 1)
    assert(Excercise0201.fib(3) == 2)
    assert(Excercise0201.fib(4) == 3)
    assert(Excercise0201.fib(5) == 5)
    assert(Excercise0201.fib(6) == 8)
    assert(Excercise0201.fib(25) == 75025)
  }
}