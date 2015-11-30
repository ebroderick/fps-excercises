package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0318TestSuite extends FunSuite {
  test("map") {
    val l1 = List(1, 2, 3, 4)
    assert(Exercise0318.map(l1)(_.toString) == List("1", "2", "3", "4"))
  }

  test("map2") {
    val l1 = List(1, 2, 3, 4)
    assert(Exercise0318.map2(l1)(_.toString) == List("1", "2", "3", "4"))
  }
}
