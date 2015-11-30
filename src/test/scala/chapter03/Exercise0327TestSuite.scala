package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0327TestSuite extends FunSuite {
  test("depth") {
    val t = Branch(Leaf(12), Leaf(9))
    assert(Exercise0327.depth(t) == 2)

    assert(Exercise0327.depth(Leaf(1)) == 1)

    val t2 = Branch(
               Branch(
                 Branch(
                   Leaf(1),
                   Leaf(3)
                 ),
                 Branch(
                   Leaf(15),
                   Leaf(6)
                 )
                ),
               Leaf(7)
             )

    assert(Exercise0327.depth(t2) == 4)
  }
}
