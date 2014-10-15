package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0329TestSuite extends FunSuite {
  test("size with fold example") {
    val tree = Leaf("test")

    assert(Excercise0329.sizeWithFold(tree) == 1)

    val largerTree = Branch(Branch(Leaf(""),Leaf("")), Leaf(""))

    assert(Excercise0329.sizeWithFold(largerTree) == 5)
  }

  test("max with fold example") {
    val tree = Leaf(5)

    assert(Excercise0329.maxWithFold(tree) == 5)

    val largerTree = Branch(Branch(Leaf(2),Leaf(7)), Leaf(4))

    assert(Excercise0329.maxWithFold(largerTree) == 7)
  }

  test("depth with fold example") {
    val tree = Leaf(5)

    assert(Excercise0329.depthWithFold(tree) == 1)

    val largerTree = Branch(Branch(Leaf(2),Branch(Leaf(3), Leaf(4))), Leaf(4))

    assert(Excercise0329.depthWithFold(largerTree) == 4)
  }

  test("map example") {
    val tree = Leaf(5)

    assert(Excercise0329.mapWithFold(tree)(_ + 1) == Leaf(6))

    val largerTree = Branch(Branch(Leaf(2),Branch(Leaf(3), Leaf(4))), Leaf(4))

    assert(Excercise0329.mapWithFold(largerTree)(_ + 1) == Branch(Branch(Leaf(3),Branch(Leaf(4), Leaf(5))), Leaf(5)))
  }
}