package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0320TestSuite extends FunSuite {
  test("flatMap") {
    val l1 = List(1, 2, 3)
    assert(Exercise0320.flatMap(l1)(i => List(i, i)) == List(1, 1, 2, 2, 3, 3))
  }
}
