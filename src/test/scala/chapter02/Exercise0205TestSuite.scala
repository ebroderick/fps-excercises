package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0205TestSuite extends FunSuite {
  test("testCompose") {
    val f1 = (a: Int) => a * 2
    val f2 = (a: Int) => a + 2

    assert(Exercise0205.compose(f2, f1)(2) == 6)

    val f3 = f1 andThen f2
    assert(f3(2) == 6)

    val f4 = f2 compose f1
    assert(f3(2) == 6)
  }
}