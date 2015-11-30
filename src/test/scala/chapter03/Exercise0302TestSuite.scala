package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0302TestSuite  extends FunSuite {
  test("tail") {
    val l = List(1, 2, 3, 4)
    assert(List(2, 3, 4) == Exercise0302.tail(l))
  }

}
