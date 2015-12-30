package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0606TestSuite  extends FunSuite {

  test("map2") {
    val s: RNG = SimpleRNG(1)
    val f = Exercise0606.map2(Exercise0602.double, Exercise0601.nonNegativeInt)((_, _))
    val ((d, i), ns) = f(s)
    assert(d < 1 && i >= 0)
  }

}
