package chapter03

/**
  * @author brodericke
  */
object Exercise0314 {

  def append[A](a1: List[A], a2: List[A]): List[A] = List.foldRight(a1, a2)((a, b) => Cons(a, b))

}
