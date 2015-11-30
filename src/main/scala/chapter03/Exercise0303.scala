package chapter03

/**
  * @author brodericke
  */
object Exercise0303 {
  def setHead[A](l: List[A], newHead: A): List[A] = l match {
    case Nil => Nil
    case Cons(_, xs) => Cons(newHead, xs)
  }
}
