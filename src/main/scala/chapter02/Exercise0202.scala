package chapter02

import scala.annotation.tailrec

object Exercise0202 {

  @tailrec
  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = as match {
    case Array() => true
    case Array(_) => true
    case Array(x, y, _*) => if (ordered(x, y)) isSorted(as.tail, ordered) else false
  }

  def isSorted2[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(aHead: A, aTail: Array[A]): Boolean = {
      if (aTail.isEmpty) true
      else {
        val nextA = aTail.head
        if (ordered(aHead, nextA)) go(nextA, aTail.tail) else false
      }
    }

    if (as.isEmpty) true else go(as.head, as.tail)
  }
}


