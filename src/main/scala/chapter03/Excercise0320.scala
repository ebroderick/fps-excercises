package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0320 {

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

  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] = {
    foldRight(as, List[B]())((a, list) => foldRight(f(a), list)((a2: B, l2) => Cons(a2, l2)))
  }

}
