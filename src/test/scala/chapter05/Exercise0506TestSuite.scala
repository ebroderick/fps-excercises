package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0506TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("headOption") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.headOption().contains(1))

    val s2 = Empty
    assert(s2.headOption().isEmpty)
  }

}
