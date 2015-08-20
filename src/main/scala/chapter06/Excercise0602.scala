package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0602 {
  def double(rng: RNG): (Double, RNG) = {
    val (i, g) = Excercise0601.nonNegativeInt(rng)
    val double = if (i <= 1) 2d else i.toDouble
    (1 / double, g)
  }
}
