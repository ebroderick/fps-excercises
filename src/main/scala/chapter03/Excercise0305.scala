package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0305 {
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (f(x)) dropWhile(xs, f) else l
  }
}
