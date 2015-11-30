package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0304TestSuite extends FunSuite {
  test("drop") {
    val l = List(1, 2, 3, 4)
    assert(List(3, 4) == Exercise0304.drop(l, 2))
    assert(Nil == Exercise0304.drop(l, 99))
  }

}
