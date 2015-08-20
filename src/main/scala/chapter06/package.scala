/**
 * Created by brodericke on 12/23/14.
 */
package object chapter06 {
  trait RNG {
    def nextInt: (Int, RNG)
  }

  object RNG {
    def unit[A](a: A): Rand[A] = rng => (a, rng)
    def map[A,B](s: Rand[A])(f: A => B): Rand[B] =
      rng => {
        val (a, rng2) = s(rng)
        (f(a), rng2)
      }
  }

  type Rand[+A] = RNG => (A, RNG)

  case class SimpleRNG(seed: Long) extends RNG {
    def nextInt: (Int, RNG) = {
      val newSeed = (seed * 0x5DEECE66DL + 0xBL) & 0xFFFFFFFFFFFFL
      val nextRNG = SimpleRNG(newSeed)
      val n = (newSeed >>> 16).toInt
      (n, nextRNG)
    }
  }
}
