package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0305TestSuite extends FunSuite {
  test("dropWhile") {
    val l = List(1, 2, 3, 4)
    assert(List(3, 4) == Exercise0305.dropWhile(l, (a: Int) => a <= 2))
    assert(Nil == Exercise0305.dropWhile(l, (a: Int) => a <= 99))
  }

}
