package chapter04

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0402 {

  def mean(xs: Seq[Double]): Option[Double] = if (xs.isEmpty) None else Some(xs.sum / xs.length)

  def variance(xs: Seq[Double]): Option[Double] = mean(xs) flatMap(m => mean(xs.map(x => math.pow(x - m, 2))))

}
