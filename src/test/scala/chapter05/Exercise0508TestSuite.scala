package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0508TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("constant") {
    val s = Stream.constant(0)
    assert(s.take(3).toList == List(0, 0, 0))
  }
}
