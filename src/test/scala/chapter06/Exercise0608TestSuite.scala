package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0608TestSuite  extends FunSuite {

  test("nonNegativeLessThanViaFlatMap") {
    var s: RNG = SimpleRNG(1)
    for (_ <- 1 to 1000) {
      val (d, s2) = Exercise0608.nonNegativeLessThan(20)(s)
      assert(d >= 0 && d <= 20)
      s = s2
    }
  }

}
