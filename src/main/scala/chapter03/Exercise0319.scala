package chapter03

/**
  * @author brodericke
  */
object Exercise0319 {

  def filter[A](as: List[A])(f: A => Boolean): List[A] =
    List.foldRight(as, Nil: List[A])((a, l) => if (f(a)) Cons(a, l) else l)


}
