package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0325TestSuite extends FunSuite {
  test("size") {
    val t = Branch(Leaf(1), Leaf(1))
    assert(Exercise0325.size(t) == 3)

    assert(Exercise0325.size(Leaf(1)) == 1)
  }
}
