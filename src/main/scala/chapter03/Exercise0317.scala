package chapter03

object Exercise0317 {

  def doubleToString(ls: List[Double]): List[String] = {
    List.foldRight(ls, List[String]())((a, b) => Cons(a.toString, b))
  }
}


