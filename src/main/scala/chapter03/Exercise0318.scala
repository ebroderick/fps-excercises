package chapter03

import scala.annotation.tailrec

/**
  * @author brodericke
  */
object Exercise0318 {

  def map[A, B](as: List[A])(f: A => B): List[B] =
    List.foldRight(as, Nil: List[B])((a, l) => Cons(f(a), l))

  def map2[A, B](as: List[A])(f: A => B): List[B] = {
    @tailrec
    def go(l: List[A], r: List[B]): List[B] = l match {
      case Nil => r
      case Cons(h, t) => go(t, Exercise0314.append(r, Cons(f(h), Nil)))
    }
    go(as, Nil: List[B])
  }

}
