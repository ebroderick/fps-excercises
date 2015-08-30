package chapter03

object Exercise0304 {

  def drop[A](l: List[A], n: Int): List[A] = if (n <= 0) l else l match {
      case Nil => Nil
      case Cons(x, xs) => drop(xs, n - 1)
    }
}


