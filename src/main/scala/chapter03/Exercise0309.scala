package chapter03

/**
  * @author brodericke
  */
object Exercise0309 {
  def length[A](as: List[A]): Int = List.foldRight(as, 0)((_, b) => b + 1)
}
