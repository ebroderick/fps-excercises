package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0307 {
  def foldRight[A,B](as: List[A], z: B, stopVal: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) =>
        println(s"item: $x")
        if (x == stopVal) stopVal
        else f(x, foldRight(xs, z, stopVal)(f))
    }
  }

  def product2(ns: List[Double]) = foldRight(ns, 1.0, 0.0)(_ * _)

  def main(args: Array[String]) {
    product2(List(2.0, 0.0, 3.0, 4.0))
  }
}
