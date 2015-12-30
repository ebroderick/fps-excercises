package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0603TestSuite  extends FunSuite {

  test("intDouble") {
    val s: RNG = SimpleRNG(1)

    val (t1, s1) = Exercise0603.intDouble(s)
    val (t2, s2) = Exercise0603.intDouble(s1)

    val (i1, d1) = t1
    val (i2, d2) = t2

    assert(i1 != i2 && d1 != d2)
  }

  test("doubleInt") {
    val s: RNG = SimpleRNG(1)

    val (t1, s1) = Exercise0603.doubleInt(s)
    val (t2, s2) = Exercise0603.doubleInt(s1)

    val (d1, i1) = t1
    val (d2, i2) = t2

    assert(i1 != i2 && d1 != d2)
  }

  test("double3") {
    val s: RNG = SimpleRNG(1)

    val (t1, s1) = Exercise0603.double3(s)
    val (t2, s2) = Exercise0603.double3(s1)
    val (t3, s3) = Exercise0603.double3(s2)

    val (d1a, d1b, d1c) = t1
    val (d2a, d2b, d2c) = t2
    val (d3a, d3b, d3c) = t3

    assert(d1a != d1b && d1b != d1c && d1a != d1c)
    assert(d1a != d2a && d1b != d2b && d2a != d3a)
  }

}
