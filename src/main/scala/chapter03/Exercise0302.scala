package chapter03

/**
  * @author brodericke
  */
object Exercise0302 {
  def tail[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x, xs) => xs
  }
}
