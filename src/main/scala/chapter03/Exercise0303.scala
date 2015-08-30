package chapter03

object Exercise0303 {

  def setHead[A](a: A, as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(_, xs) => Cons(a, xs)
  }

}


