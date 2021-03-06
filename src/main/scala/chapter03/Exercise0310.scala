package chapter03

import scala.annotation.tailrec

/**
  * @author brodericke
  */
object Exercise0310 {

  @tailrec
  def foldLeft[A,B](as: List[A], z: B)(f: (B, A) => B): B = as match {
    case Nil => z
    case Cons(x, xs) => foldLeft(xs, f(z, x))(f)
  }
}
