package chapter02

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0204 {
  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a: A, b: B) => {
      val f1 = f(a)
      f1(b)
    }
  }
}
