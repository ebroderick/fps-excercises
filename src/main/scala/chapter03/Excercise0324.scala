package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0324 {

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

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    def checkSubList(mainList: List[A], subList: List[A]): Boolean = {
      subList match {
        case Nil => true
        case Cons(x, xs) => mainList match {
          case Nil => false
          case Cons(y, ys) => if (x == y) checkSubList(xs, ys) else false
        }
      }
    }

    def loop(mainList: List[A]): Boolean = {
      mainList match {
        case Nil => false
        case Cons(x, xs) => if (checkSubList(mainList, sub)) true else loop(xs)
      }
    }

    loop(sup)
  }
}
