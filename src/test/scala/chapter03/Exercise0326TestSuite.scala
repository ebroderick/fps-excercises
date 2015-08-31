package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0326TestSuite extends FunSuite {

  test("maximum") {
    assert(Exercise0326.maximum(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Exercise0326.maximum(Leaf(1)) == 1)
    assert(Exercise0326.maximum(Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(6), Leaf(3)), Leaf(8)))) == 8)
    assert(Exercise0326.maximum(Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(6), Leaf(3)), Leaf(2)))) == 6)
  }
}