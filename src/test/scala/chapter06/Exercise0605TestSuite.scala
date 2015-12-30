package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0605TestSuite  extends FunSuite {

  test("doubleViaMap") {
    var s: RNG = SimpleRNG(1)
    for (_ <- 1 to 1000) {
      val (d, s2) = Exercise0605.doubleViaMap(s)
      assert(d >= 0 && d < 1)
      s = s2
    }
  }

}
