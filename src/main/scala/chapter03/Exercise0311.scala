package chapter03

/**
  * @author brodericke
  */
object Exercise0311 {

  def sum(as: List[Int]) = List.foldLeft(as, 0)(_ + _)
  def product(as: List[Int]) = List.foldLeft(as, 1)(_ * _)
  def length(as: List[Int]) = List.foldLeft(as, 0)((b, _) => b + 1)
}
