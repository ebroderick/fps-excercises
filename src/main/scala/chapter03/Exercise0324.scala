package chapter03

import scala.annotation.tailrec

object Exercise0324 {

  def hasSubsequence[A](as1: List[A], as2: List[A]): Boolean = {
    @tailrec
    def go(l1: List[A], l2: List[A], matches: Boolean): Boolean = {
      l2 match {
        case Nil => matches
        case Cons(h1, t1) => l1 match {
          case Nil => false
          case Cons(h2, t2) => if (h1 == h2) go(t2, t1, true) else go(t2, as2, false)
        }
      }
    }
    go(as1, as2, false)
  }
}


