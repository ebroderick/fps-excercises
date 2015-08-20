package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0607 {

 /* def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng => {
      val (a, r1) = ra(rng)
      val (b, r2) = rb(r1)
      (f(a, b), r2)
    }
  }

  def both[A,B](ra: Rand[A], rb: Rand[B]): Rand[(A,B)] = map2(ra, rb)((_, _))*/

  def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {
    rng => fs.foldLeft((List[A](), rng))((b, randA) => {
      val (list, lastRng) = b
      val (a, nextRng) = randA(lastRng)
      (list :+ a, nextRng)
    })
  }

  def ints(count: Int): Rand[List[Int]] =
    sequence(List.fill(count)((r: RNG) => r.nextInt))

}
