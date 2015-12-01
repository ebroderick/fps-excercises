package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0405TestSuite  extends FunSuite {
  import Exercise0401._

  test("traverse") {
    assert(Exercise0405.traverse(List("1", "2"))(x => Try(x.toInt)) == Some(List(1, 2)))
    assert(Exercise0405.traverse(List("1", "two"))(x => Try(x.toInt)) == None)
  }

  test("traverse2") {
    assert(Exercise0405.traverse2(List("1", "2"))(x => Try(x.toInt)) == Some(List(1, 2)))
    assert(Exercise0405.traverse2(List("1", "two"))(x => Try(x.toInt)) == None)
  }

  test("sequenceViaTraverse") {
    val o1 = Some(1)
    val o2 = Some(2)

    assert(Exercise0405.sequenceViaTraverse(List(o1, o2)) == Some(List(1, 2)))

    val o3 = None
    assert(Exercise0405.sequenceViaTraverse(List(o1, o2, o3)) == None)
    assert(Exercise0405.sequenceViaTraverse(List(o3, o2, o1)) == None)

    assert(Exercise0405.sequenceViaTraverse(List()) == Some(List()))
  }
}
