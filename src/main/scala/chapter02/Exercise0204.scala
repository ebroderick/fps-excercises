package chapter02

object Exercise0204 {

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)
}


