package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0329TestSuite extends FunSuite {

  test("sizeViaFold") {
    assert(Exercise0329.sizeViaFold(Branch(Leaf(1), Leaf(2))) == 3)
    assert(Exercise0329.sizeViaFold(Leaf(1)) == 1)
    assert(Exercise0329.sizeViaFold(Branch(Branch(Leaf(1), Leaf(2)), Leaf(2))) == 5)
  }

  test("maximumViaFold") {
    assert(Exercise0329.maximumViaFold(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Exercise0329.maximumViaFold(Leaf(1)) == 1)
    assert(Exercise0329.maximumViaFold(Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(6), Leaf(3)), Leaf(8)))) == 8)
    assert(Exercise0329.maximumViaFold(Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(6), Leaf(3)), Leaf(2)))) == 6)
  }

  test("depthViaFold") {
    assert(Exercise0329.depthViaFold(Branch(Leaf(1), Leaf(2))) == 2)
    assert(Exercise0329.depthViaFold(Leaf(1)) == 1)
    assert(Exercise0329.depthViaFold(Branch(Branch(Leaf(1), Leaf(2)), Branch(Branch(Leaf(6), Leaf(3)), Leaf(8)))) == 4)

    assert(Exercise0329.depthViaFold(
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

  test("mapViaFold") {
    assert(Exercise0329.mapViaFold(Branch(Leaf(1), Leaf(2)))(a => -a) == Branch(Leaf(-1), Leaf(-2)))
  }
}