package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0407TestSuite extends FunSuite {
  test("either.sequence example") {
    assert(Excercise0407.sequence(List(Right(1), Left(false))) == Left(false))
    assert(Excercise0407.sequence(List(Right(1), Right(2))) == Right(List(1, 2)))
    assert(Excercise0407.sequence(List(Right(1), Left(false), Right(3))) == Left(false))
  }

  test("traverse example") {
    assert(Excercise0407.traverse(List(1, 2))(i => if (i > 1) Left(false) else Right(i)) == Left(false))
    assert(Excercise0407.traverse(List(1, 2))(i => Right(i + i)) == Right(List(2, 4)))
  }
}