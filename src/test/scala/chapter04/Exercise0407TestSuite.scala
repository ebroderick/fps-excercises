package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0407TestSuite  extends FunSuite {
  import Exercise0406._

  test("traverse") {
    assert(Exercise0407.traverse(List("1", "2"))(x => Try(x.toInt)) == Right(List(1, 2)))
    assert(Exercise0407.traverse(List("1", "two"))(x => Try(x.toInt)).isInstanceOf[Left[_]])
  }

  test("sequenceViaTraverse") {
    val e1 = Right(1)
    val e2 = Right(2)

    assert(Exercise0407.sequence(List(e1, e2)) == Right(List(1, 2)))

    val e3 = Left("Error")
    assert(Exercise0407.sequence(List(e1, e2, e3)) == e3)
    assert(Exercise0407.sequence(List(e3, e2, e1)) == e3)

    assert(Exercise0407.sequence(List()) == Right(List()))
  }
}
