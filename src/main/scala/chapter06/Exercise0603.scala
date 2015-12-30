package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0603 {

  def intDouble(rng: RNG): ((Int,Double), RNG) = {
    val (i, s1) = Exercise0601.nonNegativeInt(rng)
    val (d, s2) = Exercise0602.double(s1)
    ((i, d), s2)
  }

  def doubleInt(rng: RNG): ((Double,Int), RNG) = {
    val (d, s1) = Exercise0602.double(rng)
    val (i, s2) = Exercise0601.nonNegativeInt(s1)
    ((d, i), s2)
  }

  def double3(rng: RNG): ((Double,Double,Double), RNG) = {
    val (d1, s1) = Exercise0602.double(rng)
    val (d2, s2) = Exercise0602.double(s1)
    val (d3, s3) = Exercise0602.double(s2)
    ((d1, d2, d3), s3)
  }
}
