package misc

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Folds extends FunSuite {
  test("fold examples using scala list") {

    /*  def foldLeft[B](z: B)(f: (B, A) ⇒ B): B

          Applies a binary operator to a start value and all elements of this sequence, going left to right.

        def foldRight[B](z: B)(op: (A, B) ⇒ B): B

          Applies a binary operator to all elements of this list and a start value, going right to left.

        def +:(elem: A): List[A]

          [use case] A copy of the list with an element prepended.

        def :+(elem: A): List[A]

          [use case] A copy of this list with an element appended.
    */

    val list1 = List(1, 2, 3, 4)

    assert(list1.foldLeft(List[Int]())((l: List[Int], i: Int) => l :+ i) == List(1, 2, 3, 4))
    assert(list1.foldRight(List[Int]())((i: Int, l: List[Int]) => l :+ i) == List(4, 3, 2, 1))
    assert(list1.foldRight(List[Int]())((i: Int, l: List[Int]) => i +: l) == List(1, 2, 3, 4))
  }
}
