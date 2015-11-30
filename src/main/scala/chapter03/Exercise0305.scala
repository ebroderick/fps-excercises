package chapter03

/**
  * @author brodericke
  */
object Exercise0305 {
  def dropWhile[A](l: List[A], f: A => Boolean): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => if (f(x)) dropWhile(xs, f) else Cons(x, xs)
  }
}
