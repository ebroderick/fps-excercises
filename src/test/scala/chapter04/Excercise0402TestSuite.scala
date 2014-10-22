package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0402TestSuite extends FunSuite {
  test("variance example") {
    assert(Excercise0402.variance(Seq()) == None)
    assert(Excercise0402.variance(Seq(1.0, 1.0, 1.0)) == Some(0))
  }
}