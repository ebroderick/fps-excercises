package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0606 {
  def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = rng => {
    val (a, s1) = ra(rng)
    val (b, s2) = rb(s1)
    (f(a, b), s2)
  }
}
