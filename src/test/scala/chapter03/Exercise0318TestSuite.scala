package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0318TestSuite extends FunSuite {

  test("map") {
    val list = List(1, 2, 3)
    assert(Exercise0318.map(list)(a => -a) == List(-1, -2, -3))
  }
}