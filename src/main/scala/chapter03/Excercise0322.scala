package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0322 {

  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = {
    @tailrec
    def loop(xs: List[A], y: B): B = {
      xs match {
        case Nil => y
        case Cons(l, ls) => loop(ls, f(y, l))
      }
    }

    loop(as, z)
  }

  def combine(as1: List[Int], as2: List[Int]): List[Int] = {
    as1 match {
      case Nil => Nil
      case Cons(a1Head, a1Tail) => as2 match {
        case Nil => Nil
        case Cons(a2Head, a2Tail) => Cons(a1Head + a2Head, combine(a1Tail, a2Tail))
      }
    }
  }


}
