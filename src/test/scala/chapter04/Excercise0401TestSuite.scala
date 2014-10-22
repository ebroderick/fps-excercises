package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0401TestSuite extends FunSuite {
  test("Option.map example") {
    assert(Excercise0401.Some(1).map(_ + 1) == Excercise0401.Some(2))
    assert(Excercise0401.None.map((a: Nothing) => a) == Excercise0401.None)
  }

  test("Option.flatMap example") {
    assert(Excercise0401.Some(1).flatMap(i => Excercise0401.Some(i + 1)) == Excercise0401.Some(2))
  }

  test("Option.getOrElse example") {
    assert(Excercise0401.Some(1).getOrElse("else") == 1)
    assert(Excercise0401.None.getOrElse("else") == "else")
  }

  test("Option.orElse example") {
    assert(Excercise0401.Some(1).orElse(Excercise0401.Some("else")) == Excercise0401.Some(1))
    assert(Excercise0401.None.orElse(Excercise0401.Some("else")) == Excercise0401.Some("else"))
  }

  test("Option.filter example") {
    assert(Excercise0401.Some(1).filter(_ == 1) == Excercise0401.Some(1))
    assert(Excercise0401.Some(1).filter(_ == 2) == Excercise0401.None)
    assert(Excercise0401.None.filter(i => false) == Excercise0401.None)
  }
}