package chapter03

/**
  * @author brodericke
  */
object Exercise0304 {
  def drop[A](l: List[A], n: Int): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (n == 0) Cons(x, xs) else drop(xs, n - 1)
  }
}
