package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/10/16.
  */
object Exercise1005 {
  def foldMap[A, B](as: List[A], m: Monoid[B])(f: A => B): B =
    as.foldLeft(m.zero)((b, a) => m.op(b, f(a)))
}
