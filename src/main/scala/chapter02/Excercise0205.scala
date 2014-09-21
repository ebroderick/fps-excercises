package chapter02

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0205 {
  def compose[A,B,C](f: B => C, g: A => B): A => C = {
    (a: A) => {
      val b = g(a)
      f(b)
    }
  }
}
