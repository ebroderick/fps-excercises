package chapter03

/**
  * @author brodericke
  */
object Exercise0320 {

  def flatMap[A,B](as: List[A])(f: A => List[B]): List[B] =
    List.foldRight(as, Nil: List[B])((a, l) => Exercise0314.append(f(a), l))



}
