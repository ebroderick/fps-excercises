package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0601TestSuite  extends FunSuite {

  test("nonNegativeInt") {
    var s: RNG = SimpleRNG(1)
    for (_ <- 1 to 1000) {
      val (i, ns) = Exercise0601.nonNegativeInt(s)
      assert(i >= 0)
      s = ns
    }

  }


}
