package chapter03

object Exercise0319 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] =
    List.foldRight(as, List[A]())((a, b) => if (f(a)) Cons(a, b) else b)
}


