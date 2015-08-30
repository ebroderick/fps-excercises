package chapter03

object Exercise0315 {

  def concat[A](ls: List[List[A]]): List[A] = {
    List.foldLeft(ls, List[A]())((b, a) => List.foldLeft(a, b)((b2, a2) => Exercise0314.append(b2, a2)))
  }
}


