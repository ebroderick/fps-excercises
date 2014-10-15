package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0328TestSuite extends FunSuite {
  test("map example") {
    val tree = Leaf(5)

    assert(Excercise0328.map(tree, (i: Int) => i + 1) == Leaf(6))

    val largerTree = Branch(Branch(Leaf(2),Branch(Leaf(3), Leaf(4))), Leaf(4))

    assert(Excercise0328.map(largerTree, (i: Int) => i + 1) == Branch(Branch(Leaf(3),Branch(Leaf(4), Leaf(5))), Leaf(5)))
  }
}