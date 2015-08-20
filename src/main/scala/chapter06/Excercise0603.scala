package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0603 {

  def intDouble(rng: RNG): ((Int,Double), RNG) = {
    val (int, rng1) = Excercise0601.nonNegativeInt(rng)
    val (double, rng2) = Excercise0602.double(rng1)
    ((int, double), rng2)
  }

  def doubleInt(rng: RNG): ((Double,Int), RNG) = {
    val (double, rng1) = Excercise0602.double(rng)
    val (int, rng2) = Excercise0601.nonNegativeInt(rng1)
    ((double, int), rng2)
  }

  def double3(rng: RNG): ((Double,Double,Double), RNG) = {
    val (double1, rng1) = Excercise0602.double(rng)
    val (double2, rng2) = Excercise0602.double(rng1)
    val (double3, rng3) = Excercise0602.double(rng2)
    ((double1, double2, double3), rng3)
  }
}
