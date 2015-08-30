package chapter03

object Exercise0323 {

  def zipWith[A, B, C](as1: List[A], as2: List[B])(f: (A, B) => C): List[C] = (as1, as2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(f(h1, h2), zipWith(t1, t2)(f))
  }
}


