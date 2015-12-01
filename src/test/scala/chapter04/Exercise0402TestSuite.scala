package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0402TestSuite  extends FunSuite {

  test("variance") {
    val l = Seq(2.0, 2.0, 2.0)
    assert(Exercise0402.mean(l).contains(2.0))

    assert(Exercise0402.variance(l).contains(0.0))
  }
}
