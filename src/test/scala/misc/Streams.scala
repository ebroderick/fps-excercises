package misc

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Streams extends FunSuite {
  test("stream examples using scala's Stream class") {

    /*  def foldRight[B](z: B)(f: (A, B) ⇒ B): B

        Applies a binary operator to all elements of this sequence and a start value, going right to left.
    */

    val stream1 = Stream(1, 2, 3, 4)

    assert(stream1.foldRight(List[Int]())((i: Int, l: List[Int]) => { println(s"checking ${i}"); i +: l }) == List(1, 2, 3, 4))
  }
}
