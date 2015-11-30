package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0310TestSuite extends FunSuite {
  test("foldLeft") {
    val l = List(1, 2, 3, 4)
    assert(Exercise0310.foldLeft(l, 0)(_ + _) == 10)
  }
}
