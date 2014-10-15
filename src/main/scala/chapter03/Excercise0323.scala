package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0323 {

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

  def zipWith[A](as1: List[A], as2: List[A])(f: (A, A) => A): List[A] = {
    as1 match {
      case Nil => Nil
      case Cons(a1Head, a1Tail) => as2 match {
        case Nil => Nil
        case Cons(a2Head, a2Tail) => Cons(f(a1Head, a2Head), zipWith(a1Tail, a2Tail)(f))
      }
    }
  }


}
