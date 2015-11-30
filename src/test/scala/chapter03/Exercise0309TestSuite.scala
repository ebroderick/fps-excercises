package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0309TestSuite extends FunSuite {
  test("length") {
    val l = List(1, 2, 3, 4)
    assert(Exercise0309.length(l) == 4)
  }
}
