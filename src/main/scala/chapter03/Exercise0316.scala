package chapter03

/**
  * @author brodericke
  */
object Exercise0316 {

  def add1(l: List[Int]): List[Int] = List.foldRight(l, Nil: List[Int])((i, l2) => Cons(i + 1, l2))

}
