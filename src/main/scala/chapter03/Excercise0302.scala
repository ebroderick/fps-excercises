package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0302 {
  def tail[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case Cons(x, xs) => xs
  }
}
