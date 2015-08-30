package chapter03

object Exercise0316 {

  def add1(ls: List[Int]): List[Int] = {
    List.foldRight(ls, List[Int]())((a, b) => Cons(a + 1, b))
  }
}


