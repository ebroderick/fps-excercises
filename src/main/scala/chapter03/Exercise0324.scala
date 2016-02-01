package chapter03

/**
  * @author brodericke
  */
object Exercise0324 {

  def hasSubsequence[A](sup: List[A], sub: List[A]): Boolean = {
    def go(partialSub: List[A], l: List[A], fullSub: List[A], matches: Boolean): Boolean = (partialSub, l) match {
      case (Nil, _) => matches
      case (_, Nil) => false
      case (Cons(x, xs), Cons(y, ys)) =>
        if (x == y) {
          go(xs, ys, fullSub, matches = true)
        } else {
          fullSub match {
            case Cons(z, zs) => if (y == z) go(fullSub, l, fullSub, matches = false) else go(fullSub, ys, fullSub, matches = false)
            case Nil => false
          }
        }
    }
    go(sub, sup, sub, matches = false)
  }


  def hasSubsequence2[A](sup: List[A], sub: List[A]): Boolean = sup match {
    case Nil => sub == Nil
    case _ if startsWith(sup, sub) => true
    case Cons(x, xs) => hasSubsequence2(xs, sub)
  }

  def startsWith[A](l: List[A], sub: List[A]): Boolean = (l, sub) match {
    case (_, Nil) => true
    case (Cons(x, xs), Cons(y, ys)) => if (x == y) startsWith(xs, ys) else false
    case (Nil, _) => false
  }

}
