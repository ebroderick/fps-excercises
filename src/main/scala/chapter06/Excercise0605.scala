package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0605 {

  def double(rng: RNG): (Double, RNG) = {
    val nonNegativeInt: Rand[Int] = rng => Excercise0601.nonNegativeInt(rng)
    val mapFn = RNG.map(nonNegativeInt)(a => 1 / (if (a <= 1) 2d else a.toDouble))
    mapFn(rng)
  }
}
