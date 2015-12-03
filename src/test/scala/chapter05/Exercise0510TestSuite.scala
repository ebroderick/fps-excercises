package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0510TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("fibs") {
    val s = Stream.fibs()
    assert(s.take(6).toList == List(0, 1, 1, 2, 3, 5))
  }
}
