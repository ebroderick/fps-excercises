package chapter03

/**
  * @author brodericke
  */
object Exercise0317 {

  def doubleToString(l: List[Double]): List[String] =
    List.foldRight(l, Nil: List[String])((d, l2) => Cons(d.toString, l2))

}
