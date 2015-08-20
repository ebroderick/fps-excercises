package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0609 {

  def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, nextRng) = f(rng)
      g(a)(nextRng)
    }
  }

  def map[A,B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  def mapWithFlatMap[A,B](s: Rand[A])(f: A => B): Rand[B] =
    flatMap(s)(a => RNG.unit(f(a)))


  def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng => {
      val (a, r1) = ra(rng)
      val (b, r2) = rb(r1)
      (f(a, b), r2)
    }
  }

  def map2WithFlatMap[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    flatMap(ra)(a => flatMap(rb)(b => RNG.unit(f(a, b))))
}
