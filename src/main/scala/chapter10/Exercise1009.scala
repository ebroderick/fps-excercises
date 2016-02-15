package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/10/16.
  */
object Exercise1009 {
  def isOrdered(v: IndexedSeq[Int]): Boolean =
    Exercise1007.foldMapV(v, new Monoid[Int] {
      def op(a1: Int, a2: Int): Int = if (a1 == -1 || a2 < a1) -1 else 1
      def zero: Int = 1
    })(identity) == 1

  def main(args: Array[String]) {
    val v = IndexedSeq(1, 2, 3, 4, 0, 6, 7)
    println(isOrdered(v))
  }
}
