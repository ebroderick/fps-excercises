package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0203TestSuite extends FunSuite {
  test("currying example 1") {
    val f1 = Excercise0203.curry((num1: Int, num2: Int) => num1 + num2)
    val f2 = f1(1)
    val result = f2(2)
    assert(result == 3)
  }

  test("currying example 2") {
    val f1 = Excercise0203.curry((string1: String, string2: String) => string1 == string2)
    val f2 = f1("test")
    val result = f2("test2")
    assert(!result)

    val result2 = f2("test")
    assert(result2)
  }
}