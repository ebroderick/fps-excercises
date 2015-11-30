package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0323TestSuite extends FunSuite {
  test("zipWith") {
    val l1 = List(1, 2, 3, 4)
    val l2 = List(1, 1, 1, 1)
    assert(Exercise0323.zipWith(l1, l2)(_ + _) == List(2, 3, 4, 5))

    assert(Exercise0323.zipWith(l1, l2)((_, _)) == List((1, 1), (2, 1), (3, 1), (4, 1)))
  }
}
