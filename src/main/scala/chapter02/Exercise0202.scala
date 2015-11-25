package chapter02

import scala.annotation.tailrec

object Exercise0202 {

  @tailrec
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean =  as.toList match {
    case Nil => true
    case x :: Nil => true
    case x :: y :: xs => if (ordered(x, y)) isSorted(as.tail, ordered) else false
  }

  def isSorted2[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    @tailrec
    def go(index: Int): Boolean = {
      if (index + 1 >= as.length) true
      else if (ordered(as(index), as(index + 1))) go(index + 1)
      else false
    }
    go(0)
  }
}


