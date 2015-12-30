package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0602 {

  def double(rng: RNG): (Double, RNG) = {
    val (n, s) = Exercise0601.nonNegativeInt(rng)
    (1.toDouble / n, s)
  }
}
