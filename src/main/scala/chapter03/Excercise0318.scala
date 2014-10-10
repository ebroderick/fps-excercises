package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0318 {

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

  def map[A,B](as: List[A])(f: A => B): List[B] = {
    foldRight(as, List[B]())((a, list) => Cons(f(a), list))
  }

}
