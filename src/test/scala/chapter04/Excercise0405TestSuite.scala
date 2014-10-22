package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0405TestSuite extends FunSuite {
  test("traverse example") {
    assert(Excercise0405.traverse(List(1, 2))(i => if (i > 1) None else Some(i)) == None)
    assert(Excercise0405.traverse(List(1, 2))(i => Some(i + i)) == Some(List(2, 4)))
  }
}