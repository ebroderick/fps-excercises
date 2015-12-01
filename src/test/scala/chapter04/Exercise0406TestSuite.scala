package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0406TestSuite  extends FunSuite {
  import Exercise0406._

  test("map") {
    val r = Right(1)
    assert(r.map(_.toString) == Right("1"))

    val l = Left("Error")
    assert(l.map(x => x.toString) == l)
  }

  test("flatMap") {
    val r = Right(1)
    assert(r.flatMap(x => Right(x.toString)) == Right("1"))
    assert(r.flatMap(x => Left("Error")) == Left("Error"))

    val l = Left("Error")
    assert(l.flatMap(x => Right(x.toString)) == Left("Error"))
  }

  test("orElse") {
    val r = Right(1)
    assert(r.orElse(Left("Error")) == r)

    val l = Left("Error")
    assert(l.orElse(r) == r)
  }

  test("map2") {
    val r1 = Right(1)
    val r2 = Right(2)
    assert(r1.map2(r2)(_ + _) == Right(3))

    val l = Left("Error")
    assert(l.map2(r2)((_, _)) == Left("Error"))
    assert(r1.map2(l)((_, _)) == Left("Error"))
  }
}
