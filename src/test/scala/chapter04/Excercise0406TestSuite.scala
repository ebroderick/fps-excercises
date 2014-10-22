package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0406TestSuite extends FunSuite {
  test("Either.map example") {
    assert(Excercise0406.Right(1).map(_ + 1) == Excercise0406.Right(2))
    assert(Excercise0406.Left(false).map((a: Nothing) => a) == Excercise0406.Left(false))
  }

  test("Either.flatMap example") {
    assert(Excercise0406.Right(1).flatMap(i => Excercise0406.Right(i + 1)) == Excercise0406.Right(2))
  }

  test("Either.orElse example") {
    assert(Excercise0406.Right(1).orElse(Excercise0406.Right("else")) == Excercise0406.Right(1))
    assert(Excercise0406.Left(false).orElse(Excercise0406.Right("else")) == Excercise0406.Right("else"))
  }

  test("Either map2 example") {
    assert(Excercise0406.Right(1).map2(Excercise0406.Right(2))((a, b) => a + b) == Excercise0406.Right(3))
    assert(Excercise0406.Left(false).map2(Excercise0406.Right(2))((a, b) => b) == Excercise0406.Left(false))
    assert(Excercise0406.Left(false).map2(Excercise0406.Left(false))((a, b) => b) == Excercise0406.Left(false))
    assert(Excercise0406.Right(1).map2(Excercise0406.Left(false))((a, b) => b) == Excercise0406.Left(false))
  }
}