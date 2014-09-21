package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0205TestSuite extends FunSuite {
  test("compose example") {
    val f1 = (str: String) => str.toUpperCase
    val f2 = (str: String) => str.replaceAll("A", "")

    assert(f1("asdf") == "ASDF")
    assert(f2("ASDF") == "SDF")

    val composed = Excercise0205.compose(f2, f1)

    assert(composed("asdf") == "SDF")
  }

}