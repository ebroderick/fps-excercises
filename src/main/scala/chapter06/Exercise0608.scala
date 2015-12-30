package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0608 {

  def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] = rng => {
    val (a, s) = f(rng)
    g(a)(s)
  }

  def nonNegativeLessThan(i: Int): Rand[Int] = flatMap(Exercise0601.nonNegativeInt) { a =>
    val mod = i % a
    if (i + (a - 1) - mod >= 0) unit(mod)
    else nonNegativeLessThan(i)
  }
}
