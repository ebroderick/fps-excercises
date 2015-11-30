package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0328TestSuite extends FunSuite {
  test("map") {
    val t = Branch(Leaf(12), Leaf(9))
    assert(Exercise0328.map(t)(_.toString) == Branch(Leaf("12"), Leaf("9")))

    assert(Exercise0328.map(Leaf(1))(_.toString) == Leaf("1"))

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

    assert(Exercise0328.map(t2)(_.toString) == Branch(
      Branch(
        Branch(
          Leaf("1"),
          Leaf("3")
        ),
        Branch(
          Leaf("15"),
          Leaf("6")
        )
      ),
      Leaf("7")
    ))
  }
}
