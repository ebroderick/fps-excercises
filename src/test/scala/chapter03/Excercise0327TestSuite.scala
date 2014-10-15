package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0327TestSuite extends FunSuite {
  test("depth example") {
    val tree = Leaf(5)

    assert(Excercise0327.depth(tree) == 1)

    val largerTree = Branch(Branch(Leaf(2),Branch(Leaf(3), Leaf(4))), Leaf(4))

    assert(Excercise0327.depth(largerTree) == 4)
  }
}