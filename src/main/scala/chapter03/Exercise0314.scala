package chapter03

object Exercise0314 {

  def append[A](l: List[A], item: A): List[A] = {
    List.foldRight(l, Cons(item, Nil))((a, b) => Cons(a, b))
  }
}


