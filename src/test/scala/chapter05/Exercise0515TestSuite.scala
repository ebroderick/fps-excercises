package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0515TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("tails") {
    val s = Stream(1, 2, 3)
    val tails = s.tails()
    val mappedTails = tails.map(_.toList)

    assert(mappedTails.toList == List(List(1, 2, 3), List(2, 3), List(3)))
  }

}
