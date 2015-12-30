package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0607 {
  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = rng => fs.foldRight((List[A](), rng)) {
    case (r, (l, s)) =>
      val (v, ns) = r(s)
      (v :: l, ns)
  }

  def intsViaSequence(i: Int)(rng: RNG): (List[Int], RNG)  = {
    val l: List[Rand[Int]] = List.fill(i)(Exercise0601.nonNegativeInt)
    sequence(l)(rng)
  }

  def sequence2[A](fs: List[Rand[A]]): Rand[List[A]] = fs.foldRight(unit(List[A]()))((r, acc) =>
    Exercise0606.map2(r, acc)(_ :: _)
  )
}
