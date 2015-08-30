package chapter03

object Exercise0321 {

  def filterWithFlatMap[A,B](as: List[A])(f: A => Boolean): List[A] =
    Exercise0320.flatMap(as)(a => if (f(a)) List[A](a) else List[A]())
}


