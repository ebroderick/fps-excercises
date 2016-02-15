package chapter11

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ebroderick on 2/12/16.
  */
@RunWith(classOf[JUnitRunner])
class Exercise1103 extends FunSuite {

  test("testMonadSequence") {
    val o = Exercise1101.optionMonad.sequence(
      List(Some(1), Some(2), Some(3))
    )
    assert(o.get == List(1, 2, 3))
  }

  test("testMonadTraverse") {
    val o: Option[List[Int]] = Exercise1101.optionMonad.traverse(
      List(Some(1), Some(2), Some(3))
    )((o) => Some(o.get + 1))

    assert(o.get == List(2, 3, 4))
  }
}
