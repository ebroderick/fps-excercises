package chapter03

/**
  * @author brodericke
  */
object Exercise0322 {

  def sumLists(as: List[Int], bs: List[Int]): List[Int] = {
    def go(l1: List[Int], l2: List[Int], r: List[Int]): List[Int] = l1 match {
      case Nil => r
      case Cons(h1, t1) => l2 match {
        case Cons(h2, t2) => go(t1, t2, Exercise0314.append(r, Cons(h1 + h2, Nil)))
        case Nil => Nil
      }
    }
    go(as, bs, Nil: List[Int])
  }

  def sumLists2(as: List[Int], bs: List[Int]): List[Int] = (as, bs) match {
    case (Nil, _) => Nil
    case (_, Nil) => Nil
    case (Cons(h1, t1), Cons(h2, t2)) => Cons(h1 + h2, sumLists2(t1, t2))
  }


}
