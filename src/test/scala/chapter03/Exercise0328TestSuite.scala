package chapter03

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0328TestSuite extends FunSuite {

  test("map") {
    assert(Exercise0328.map(Branch(Leaf(1), Leaf(2)))(a => -a) == Branch(Leaf(-1), Leaf(-2)))
  }
}