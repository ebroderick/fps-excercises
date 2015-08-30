package chapter03

object Exercise0306 {

  def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, Nil) => Nil //skip last element
    case Cons(x, xs) => Cons(x, init(xs))
  }
}


