package chapter03

import scala.annotation.tailrec

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0306 {
  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, Nil) => Nil
    case Cons(x, xs) => Cons(x, init(xs))
  }
}
