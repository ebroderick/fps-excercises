package chapter03

object Exercise0311 {

  def foldLeftSum(xs: List[Int]): Int = List.foldLeft(xs, 0)((b, a) => b + a)

  def foldLeftProduct(xs: List[Double]): Double = List.foldLeft(xs, 1.0)((b, a) => b * a)

  def foldLeftLength[A](xs: List[A]): Int = List.foldLeft(xs, 0)((b, a) => b + 1)
}


