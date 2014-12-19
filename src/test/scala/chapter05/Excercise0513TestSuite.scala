package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0513TestSuite extends FunSuite {
  test("Stream.map with unfold example") {
    assert(Excercise0513.Stream(1, 2, 3).map(_ + 1).toList == List(2, 3, 4))
  }

  test("Stream.take with unfold example") {
    assert(Excercise0513.Stream(1, 2, 3, 4, 5).takeWithUnfold(3).toList == List(1, 2, 3))
  }

  test("Stream.takeWhile with unfold example") {
    assert(Excercise0513.Stream(1, 2, 3, 4, 5).takeWhile(_ < 5).toList == List(1, 2, 3, 4))
  }

  test("Stream.zipwith with unfold example") {
    val stream1 = Excercise0513.Stream(1, 2, 3)
    val stream2 = Excercise0513.Stream(4, 5, 6)

    assert(Excercise0513.Stream.zipWith(stream1, stream2)((a1, a2) => a1 + a2).toList == List(5, 7, 9))
  }

  test("Stream.zipall with unfold example") {
    val stream1 = Excercise0513.Stream(1, 2)
    val stream2 = Excercise0513.Stream(4, 5)

    assert(stream1.zipAll(stream2).toList == List((Some(1), Some(4)), (Some(2), Some(5))))

    val stream3 = Excercise0513.Stream(1)
    assert(stream3.zipAll(stream2).toList == List((Some(1), Some(4)), (None, Some(5))))

    val stream4 = Excercise0513.Stream()
    assert(stream1.zipAll(stream4).toList == List((Some(1), None), (Some(2), None)))
  }
}