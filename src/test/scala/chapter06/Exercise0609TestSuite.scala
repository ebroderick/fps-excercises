package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0609TestSuite  extends FunSuite {

  test("mapViaFlatMap") {
    val s: RNG = SimpleRNG(1)
    val f = Exercise0609.mapViaFlatMap(Exercise0608.nonNegativeLessThan(20))(a => -a)
    val (n, s2) = f(s)
    assert(n < 0 && n >= -20)
  }

  test("map2ViaFlatMap") {
    val s: RNG = SimpleRNG(1)
    val f = Exercise0609.map2ViaFlatMap(Exercise0602.double, Exercise0601.nonNegativeInt)((_, _))
    val ((d, i), ns) = f(s)
    assert(d < 1 && i >= 0)
  }

  test("map2ViaFlatMap2") {
    val s: RNG = SimpleRNG(1)
    val f = Exercise0609.map2ViaFlatMap2(Exercise0602.double, Exercise0601.nonNegativeInt)((_, _))
    val ((d, i), ns) = f(s)
    assert(d < 1 && i >= 0)
  }
}
