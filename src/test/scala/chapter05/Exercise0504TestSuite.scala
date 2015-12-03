package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0504TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("forAll") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.forAll(_ <= 5))
    assert(!s.forAll(_ <= 1))
  }

}
