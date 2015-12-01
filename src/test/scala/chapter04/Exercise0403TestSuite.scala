package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0403TestSuite  extends FunSuite {
  import Exercise0401._

  test("map2") {
    val a = Some(1)
    val b = Some(2)
    assert(Exercise0403.map2(a, b)(_ + _) == Some(3))

    val a2 = None: Option[Int]
    assert(Exercise0403.map2(a2, b)(_ + _) == None)
    assert(Exercise0403.map2(a, a2)(_ + _) == None)
  }
}
