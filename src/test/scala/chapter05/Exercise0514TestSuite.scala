package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0514TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("startsWith") {
    val s = Stream(1, 2, 3, 4, 5)
    val s2 = Stream(1, 2, 3)
    assert(s.startsWith(s2))

    assert(!s.startsWith(Stream(3, 4, 5)))
  }

}
