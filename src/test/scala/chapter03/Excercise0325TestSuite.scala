package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0325TestSuite extends FunSuite {
  test("size example") {
    val tree = Leaf("test")

    assert(Excercise0325.size(tree) == 1)

    val largerTree = Branch(Branch(Leaf(""),Leaf("")), Leaf(""))

    assert(Excercise0325.size(largerTree) == 5)
  }
}