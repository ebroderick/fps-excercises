package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0509TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("from") {
    val s = Stream.from(3)
    assert(s.take(3).toList == List(3, 4, 5))
  }
}
