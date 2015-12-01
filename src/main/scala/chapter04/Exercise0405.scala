package chapter04

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0405 {
  import Exercise0401._

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case x :: xs => f(x).flatMap(b => traverse(xs)(f).map(l => b :: l))
  }

  def traverse2[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
    case Nil => Some(Nil)
    case x :: xs => Exercise0403.map2(f(x), traverse2(xs)(f))((a, b) => a :: b)
  }

  def sequenceViaTraverse[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(identity)
}
