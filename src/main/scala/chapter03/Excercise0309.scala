package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0309 {
  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def length[A](as: List[A]): Int = {
    foldRight(as, 0)((a, b) => b + 1)
  }
}
