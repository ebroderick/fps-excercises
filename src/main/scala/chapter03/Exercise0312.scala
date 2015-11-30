package chapter03

/**
  * @author brodericke
  */
object Exercise0312 {

  def reverse[A](as: List[A]) = List.foldLeft(as, Nil: List[A])((b, a) => Cons(a, b))

}
