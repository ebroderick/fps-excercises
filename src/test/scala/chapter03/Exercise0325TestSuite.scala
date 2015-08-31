package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0325TestSuite extends FunSuite {

  test("size") {
    assert(Exercise0325.size(Branch(Leaf(1), Leaf(2))) == 3)
    assert(Exercise0325.size(Leaf(1)) == 1)
    assert(Exercise0325.size(Branch(Branch(Leaf(1), Leaf(2)), Leaf(2))) == 5)
  }
}