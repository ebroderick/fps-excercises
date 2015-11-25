package chapter02

import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0201TestSuite extends FunSuite {
  test("fibonacci numbers") {
    assert(Exercise0201.fib(0) == 0)
    assert(Exercise0201.fib(1) == 1)
    assert(Exercise0201.fib(2) == 1)
    assert(Exercise0201.fib(3) == 2)
    assert(Exercise0201.fib(4) == 3)
    assert(Exercise0201.fib(5) == 5)
    assert(Exercise0201.fib(6) == 8)
    assert(Exercise0201.fib(25) == 75025)
  }
}