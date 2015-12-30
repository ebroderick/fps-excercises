package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0604 {

  def ints(count: Int)(rng: RNG): (List[Int], RNG) = {
    (1 to count).foldLeft((List[Int](), rng)) {
      case (t, _) =>
        val (l, s) = t
        val (n, ns) = Exercise0601.nonNegativeInt(s)
        (n :: l, ns)
    }
  }
}
