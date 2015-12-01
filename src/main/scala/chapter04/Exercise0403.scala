package chapter04

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0403 {
  import Exercise0401._

  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = a.flatMap(x => b.map(y => f(x, y)))

}
