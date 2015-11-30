package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0311TestSuite extends FunSuite {
  test("sumProductAndLength") {
    val l = List(1, 2, 3, 4)
    assert(Exercise0311.sum(l) == 10)
    assert(Exercise0311.product(l) == 24)
    assert(Exercise0311.length(l) == 4)
  }
}
