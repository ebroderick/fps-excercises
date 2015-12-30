package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0601 {

  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (n, s) = rng.nextInt

    if (n == Int.MinValue) (0, s)
    else (scala.math.abs(n), s)
  }
}
