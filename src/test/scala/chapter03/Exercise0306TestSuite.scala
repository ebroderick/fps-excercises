package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0306TestSuite extends FunSuite {
  test("init") {
    val l = List(1, 2, 3, 4)
    assert(List(1, 2, 3) == Exercise0306.init(l))
  }
}
