package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0608 {

  def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, nextRng) = f(rng)
      g(a)(nextRng)
    }
  }

  def nonNegativeLessThan(n: Int): Rand[Int] = { rng =>
    val (i, rng2) = Excercise0601.nonNegativeInt(rng)
    val mod = i % n
    if (i + (n-1) - mod >= 0)
      (mod, rng2)
    else nonNegativeLessThan(n)(rng)
  }

  def nonNegativeLessThanWithFlatMap(n: Int): Rand[Int] =
    flatMap (Excercise0601.nonNegativeInt) { a =>
      val mod = (a % n)
      if (a + (n - 1) - mod >= 0) RNG.unit(mod) else nonNegativeLessThanWithFlatMap(n)
    }
}
