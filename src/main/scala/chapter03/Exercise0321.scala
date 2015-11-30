package chapter03

/**
  * @author brodericke
  */
object Exercise0321 {

  def filterViaFlatMap[A](as: List[A])(f: A => Boolean): List[A] =
    Exercise0320.flatMap(as)(a => if (f(a)) Cons(a, Nil) else Nil)



}
