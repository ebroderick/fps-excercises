package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0502TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("take") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.take(2).toList == List(1, 2))
  }

  test("drop") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.drop(2).toList == List(3, 4, 5))
  }
}
