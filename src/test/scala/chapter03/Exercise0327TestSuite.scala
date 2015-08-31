package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0327TestSuite extends FunSuite {

  test("depth") {
    assert(Exercise0327.depth(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Exercise0327.depth(Leaf(1)) == 1)
    assert(Exercise0327.depth(Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(6), Leaf(3)), Leaf(8)))) == 4)

    assert(Exercise0327.depth(
      Branch(
        Branch(
          Branch(
            Branch(
              Branch(Leaf(1),
                     Branch(
                       Leaf(1),
                       Branch(
                         Leaf(1),
                         Leaf(1)
                       )
                     )
              ),
              Leaf(1)),
            Leaf(1)),
          Leaf(1)),
        Leaf(8))) == 8)
  }
}