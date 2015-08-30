package chapter03

object Exercise0318 {

  def map[A,B](as: List[A])(f: A => B): List[B] =
    List.foldRight(as, List[B]())((a, b) => Cons(f(a), b))
}


