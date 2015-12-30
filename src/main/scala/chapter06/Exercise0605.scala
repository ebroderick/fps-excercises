package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0605 {
  def doubleViaMap: Rand[Double] = map(Exercise0601.nonNegativeInt)(i => 1.toDouble / i)
}
