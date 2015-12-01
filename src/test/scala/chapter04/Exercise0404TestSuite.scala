package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0404TestSuite  extends FunSuite {
  import Exercise0401._

  test("sequence") {
    val o1 = Some(1)
    val o2 = Some(2)

    assert(Exercise0404.sequence(List(o1, o2)) == Some(List(1, 2)))

    val o3 = None
    assert(Exercise0404.sequence(List(o1, o2, o3)) == None)
    assert(Exercise0404.sequence(List(o3, o2, o1)) == None)

    assert(Exercise0404.sequence(List()) == None)
  }

  test("sequence2") {
    val o1 = Some(1)
    val o2 = Some(2)

    assert(Exercise0404.sequence2(List(o1, o2)) == Some(List(1, 2)))

    val o3 = None
    assert(Exercise0404.sequence2(List(o1, o2, o3)) == None)
    assert(Exercise0404.sequence2(List(o3, o2, o1)) == None)

    assert(Exercise0404.sequence2(List()) == Some(List()))
  }
}
