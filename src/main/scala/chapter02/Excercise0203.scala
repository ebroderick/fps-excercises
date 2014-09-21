package chapter02

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0203 {
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    (a: A) => ((b: B) => f(a, b))
  }
}
