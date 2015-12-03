package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0512TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("fibsViaUnfold") {
    val s = Stream.fibsViaUnfold()
    assert(s.take(6).toList == List(0, 1, 1, 2, 3, 5))
  }

  test("fromViaUnfold") {
    val s = Stream.fromViaUnfold(3)
    assert(s.take(3).toList == List(3, 4, 5))
  }

  test("constantViaUnfold") {
    val s = Stream.constantViaUnfold(0)
    assert(s.take(3).toList == List(0, 0, 0))
  }
}
