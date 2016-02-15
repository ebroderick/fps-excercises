package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/12/16.
  */
class Exercise1017 {
  def functionMonoid[A, B](B: Monoid[B]): Monoid[A => B] =
    new Monoid[A => B] {
      override def op(a1: (A) => B, a2: (A) => B): (A) => B =
        a => B.op(a1(a), a2(a))
      override def zero: (A) => B = a => B.zero
    }
}
