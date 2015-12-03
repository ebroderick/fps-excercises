package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0507TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("map") {
    val s = Stream(1, 2, 3, 4, 5)
    val m = s.map(_.toString)
    assert(m.toList == List("1", "2", "3", "4", "5"))
  }

  test("append") {
    val s1 = Stream(1, 2)
    val s2 = Stream(3, 4)
    assert(s1.append(s2).toList == List(1, 2, 3, 4))
  }

  test("filter") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.filter(i => i < 3 || i == 5).toList == List(1, 2, 5))
  }

  test("flatMap") {
    val s = Stream(1, 2, 3)
    val fms = s.flatMap(i => Stream(i, i))
    assert(fms.toList == List(1, 1, 2, 2, 3, 3))
  }
}
