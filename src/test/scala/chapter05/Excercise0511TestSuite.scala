package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0511TestSuite extends FunSuite {
  test("Stream.unfold example") {
    val stream = Excercise0511.Stream.unfold(1)((i: Int) => if (i <= 5) Some(i, i + 1) else None)
      assert(stream.take(5).toList == List(1, 2, 3, 4, 5))
  }
}