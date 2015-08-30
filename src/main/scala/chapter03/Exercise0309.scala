package chapter03

object Exercise0309 {
  def length[A](as: List[A]): Int = List.foldRight(as, 0) ((a, b) => b + 1)
}


