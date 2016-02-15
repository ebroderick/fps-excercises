package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/12/16.
  */
object Exercise1018 {

  def bagMonoid[A](I: Monoid[Int]): Monoid[Map[A, Int]] =
    new Monoid[Map[A, Int]] {
      def op(a1: Map[A, Int], a2: Map[A, Int]): Map[A, Int] =
        a2.foldLeft(a1) {
          case (acc, (a, i)) =>
            if (acc.contains(a)) acc.updated(a, I.op(acc(a), i))
            else acc + (a -> i)
        }
      def zero: Map[A, Int] = Map[A, Int]()
    }

  def bag[A](as: IndexedSeq[A]): Map[A, Int] = {
    val m: Monoid[Map[A, Int]] = bagMonoid(Exercise1001.intAddition)
    as.foldLeft(m.zero) {
      case (acc, a) => m.op(acc, Map(a -> 1))
    }
  }

  def main(args: Array[String]) {
    println(bag(Vector("a", "rose", "is", "a", "rose")))
  }
}
