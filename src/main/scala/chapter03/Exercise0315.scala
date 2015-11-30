package chapter03

/**
  * @author brodericke
  */
object Exercise0315 {

  def concat[A](l: List[List[A]]): List[A] = List.foldRight(l, Nil: List[A])(List.append)

}
