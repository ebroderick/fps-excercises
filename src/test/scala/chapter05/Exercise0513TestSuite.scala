package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0513TestSuite  extends FunSuite {
  import chapter05.Chapter05._

  test("mapViaUnfold") {
    val s = Stream(1, 2, 3, 4, 5)
    val m = s.mapViaUnfold(_.toString)
    assert(m.toList == List("1", "2", "3", "4", "5"))
  }

  test("takeViaUnfold") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.takeViaUnfold(2).toList == List(1, 2))
  }

  test("takeWhileViaUnfold") {
    val s = Stream(1, 2, 3, 4, 5)
    assert(s.takeWhileViaUnfold(_ <= 2).toList == List(1, 2))
  }

  test("zipAll") {
    val s1 = Stream(1, 2, 3, 4)
    val s2 = Stream(10, 20, 30)
    assert(s1.zipAll(s2).toList == List((Some(1), Some(10)), (Some(2), Some(20)), (Some(3), Some(30)), (Some(4), None)))
  }

  test("zipWith") {
    val s1 = Stream(1, 2, 3, 4)
    val s2 = Stream(10, 20, 30)
    assert(s1.zipWith(s2)(_ + _).toList == List(11, 22, 33))
  }
}
