package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0205TestSuite extends FunSuite {

  test("compose") {
    val f1: Int => Int = x => x * x
    val f2: Int => Int = x => x + x
    val composed = Exercise0205.compose(f1, f2)

    assert(composed(2) == 16)
  }

  test("compose2") {
    val f1: Int => Int = x => x * x
    val f2: Int => Int = x => x + x
    val composed = Exercise0205.compose2(f1, f2)

    assert(composed(2) == 16)
  }

  test("compose3") {
    val f1: Int => Int = x => x * x
    val f2: Int => Int = x => x + x
    val composed = Exercise0205.compose3(f1, f2)

    assert(composed(2) == 16)
  }

}