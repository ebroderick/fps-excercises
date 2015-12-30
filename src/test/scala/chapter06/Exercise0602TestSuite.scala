package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0602TestSuite  extends FunSuite {

  test("double") {
    var s: RNG = SimpleRNG(1)
    for (_ <- 1 to 1000) {
      val (d, ns) = Exercise0602.double(s)
      assert(d >= 0 && d < 1)
      s = ns
    }

  }


}
