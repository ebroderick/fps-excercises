package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0329TestSuite extends FunSuite {
  test("sizeViaFold") {
    val t = Branch(Leaf(1), Leaf(1))
    assert(Exercise0329.sizeViaFold(t) == 3)

    assert(Exercise0329.sizeViaFold(Leaf(1)) == 1)
  }

  test("maxViaFold") {
    val t = Branch(Leaf(12), Leaf(9))
    assert(Exercise0329.maximumViaFold(t) == 12)

    assert(Exercise0329.maximumViaFold(Leaf(1)) == 1)

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

    assert(Exercise0329.maximumViaFold(t2) == 15)
  }

  test("depthViaFold") {
    val t = Branch(Leaf(12), Leaf(9))
    assert(Exercise0329.depthViaFold(t) == 2)

    assert(Exercise0329.depthViaFold(Leaf(1)) == 1)

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

    assert(Exercise0329.depthViaFold(t2) == 4)
  }

  test("mapViaFold") {
    val t = Branch(Leaf(12), Leaf(9))
    assert(Exercise0329.mapViaFold(t)(_.toString) == Branch(Leaf("12"), Leaf("9")))

    assert(Exercise0329.mapViaFold(Leaf(1))(_.toString) == Leaf("1"))

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

    assert(Exercise0329.mapViaFold(t2)(_.toString) == Branch(
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
