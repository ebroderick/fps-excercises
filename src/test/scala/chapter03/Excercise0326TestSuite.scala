package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0326TestSuite extends FunSuite {
  test("max example") {
    val tree = Leaf(5)

    assert(Excercise0326.max(tree) == 5)

    val largerTree = Branch(Branch(Leaf(2),Leaf(7)), Leaf(4))

    assert(Excercise0326.max(largerTree) == 7)
  }
}