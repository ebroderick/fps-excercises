package chapter04

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0401TestSuite  extends FunSuite {
  import Exercise0401._

  test("map") {
    val some = Some(2)
    assert(some.map(_.toString) == Some("2"))

    val none = None
    assert(none.map(x => x) == None)
  }

  test("getOrElse") {
    val some = Some(2)
    assert(some.getOrElse(5) == 2)

    val none = None
    assert(none.getOrElse(5) == 5)
  }

  test("flatMap") {
    val some = Some(2)
    assert(some.flatMap(x => Some(x + 2)) == Some(4))
    assert(some.flatMap(x => None) == None)

    val none = None
    assert(none.flatMap(x => Some(x)) == None)
  }

  test("orElse") {
    val some = Some(2)
    assert(some.orElse(Some(4)) == Some(2))

    val none = None
    assert(none.orElse(Some(4)) == Some(4))
  }

  test("filter") {
    val some = Some(2)
    assert(some.filter(_ % 2 != 0) == None)
    assert(some.filter(_ % 2 == 0) == Some(2))

    val none = None
    assert(none.filter(x => true) == None)
  }
}
