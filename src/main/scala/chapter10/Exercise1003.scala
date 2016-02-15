package chapter10

/**
  * Created by ebroderick on 2/9/16.
  */
object Exercise1003 {

  import Exercise1001._

  def endoMonoid[A]: Monoid[A => A] = new Monoid[A => A] {
    def op(a1: (A) => A, a2: (A) => A): (A) => A = a => a2(a1(a))
    def zero: (A) => A = a => a
  }
}
