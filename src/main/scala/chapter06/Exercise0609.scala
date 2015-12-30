package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0609 {

  def mapViaFlatMap[A,B](s: Rand[A])(f: A => B): Rand[B] = Exercise0608.flatMap(s)(a => unit(f(a)))

  def map2ViaFlatMap[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    Exercise0608.flatMap(ra)(a => Exercise0608.flatMap(rb)(b => unit(f(a, b))))

  def map2ViaFlatMap2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    Exercise0608.flatMap(ra)(a => map(rb)(b => f(a, b)))
}
