package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0303TestSuite extends FunSuite {
  test("setHead") {
    val l = List(1, 2, 3, 4)
    assert(List(99, 2, 3, 4) == Exercise0303.setHead(l, 99))
  }

}
