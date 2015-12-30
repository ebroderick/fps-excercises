package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0607TestSuite  extends FunSuite {

  test("intsViaSequence") {
    val s: RNG = SimpleRNG(1)
    val (l, _) = Exercise0607.intsViaSequence(3)(s)
    assert(l.size == 3)
    l.foreach(println)
  }

}
