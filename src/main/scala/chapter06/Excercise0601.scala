package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0601 {
  def nonNegativeInt(rng: RNG): (Int, RNG) = {
    val (i, nextRng) = rng.nextInt
    if (i == Int.MinValue) {
      (-(i + 1), nextRng)
    } else if (i < 0) {
      (-i, nextRng)
    } else {
      (i, nextRng)
    }
  }
}
