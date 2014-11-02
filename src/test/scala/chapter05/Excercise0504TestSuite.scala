package chapter05

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Excercise0504TestSuite extends FunSuite {
  test("Stream.exists example") {
    //assert(Excercise0504.Stream(1, 2, 3, 4, 5).exists(i => { println(s"checking $i"); i > 5 }) == false)

    assert(Excercise0504.Stream(1, 2, 3, 4).foldRight(List[Int]())((a, b) => { println(s"checking ${a}"); a +: b }) == List(1, 2, 3, 4))
  }
}