package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0204TestSuite extends FunSuite {
  test("uncurrying example") {
    val f1 = (str: String) => (str2: String) => str.toUpperCase + " " + str2.toUpperCase
    val f2 = f1("hello")

    assert(f2("world!") == "HELLO WORLD!")

    val uncurry = Excercise0204.uncurry(f1)

    assert(uncurry("hello", "world!") == "HELLO WORLD!")
  }

}