package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0305TestSuite extends FunSuite {

  test("dropWhile") {
    val list = List(1, 2, 3, 4, 5)
    assert(Exercise0305.dropWhile(list, (x: Int) => x < 3) == List(3, 4, 5))
    assert(Exercise0305.dropWhile(list, (x: Int) => x < 6) == Nil)
  }

}