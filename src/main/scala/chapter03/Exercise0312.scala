package chapter03

object Exercise0312 {

  def reverse[A](xs: List[A]): List[A] = List.foldLeft(xs, Nil: List[A])((b, a) => Cons(a, b))
}


