package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0326TestSuite extends FunSuite {
  test("max") {
    val t = Branch(Leaf(12), Leaf(9))
    assert(Exercise0326.maximum(t) == 12)

    assert(Exercise0326.maximum(Leaf(1)) == 1)

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

    assert(Exercise0326.maximum(t2) == 15)
  }
}
