package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0304 {
  def drop[A](l: List[A], n: Int): List[A] = n match {
    case 0 => l
    case _ => l match {
      case Nil => Nil
      case Cons(x, xs) => drop(xs, n - 1)
    }
  }
}
