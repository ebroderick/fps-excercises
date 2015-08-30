package chapter03

object Exercise0322 {

  def addCorrespondingElements(as1: List[Int], as2: List[Int]): List[Int] = as1 match {
    case Nil => Nil
    case Cons(h, t) => as2 match {
      case Nil => Nil
      case Cons(h2, t2) => Cons(h + h2, addCorrespondingElements(t, t2))
    }
  }

  def addCorrespondingElements2(as1: List[Int], as2: List[Int]): List[Int] = (as1, as2) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, addCorrespondingElements2(t1, t2))
  }
}


