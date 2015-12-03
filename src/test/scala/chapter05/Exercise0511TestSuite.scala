package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0511TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("unfold") {
    val s = Stream.unfold(1)(i => if (i < 3) Some(i.toString, i + 1) else None)
    assert(s.toList == List("1", "2"))
  }
}
