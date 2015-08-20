package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0604 {

  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    if (count == 0) {
      (List(), rng)
    } else {
      val (int1, rng1) = rng.nextInt
      val (int2, rng2) = ints(count - 1)(rng1)
      (int1 :: int2, rng2)
    }
  }
}
