package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0311 {

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

  def sum(list: List[Int]) = {
    foldLeft(list, 0)(_ + _)
  }

  def product(list: List[Double]) = {
    foldLeft(list, 1.0)(_ * _)
  }

  def length(list: List[Int]) = {
    foldLeft(list, 0)((b, a) => b + 1)
  }
}
