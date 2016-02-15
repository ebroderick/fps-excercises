package chapter11

/**
  * Created by ebroderick on 2/15/16.
  */
object Exercise1111 {
  def main(args: Array[String]) {
    val m = new Monad[List] {
      def unit[A](a: A): List[A] = List(a)
      def flatMap[A, B](fa: List[A])(f: (A) => List[B]): List[B] = fa.flatMap(f)
    }

    val f: Int => List[Int] = i => List(i * i)
    val u: Int => List[Int] = m.unit
    val fCompose1 = m.compose(f, u)
    val fCompose2 = m.compose(u, f)

    println(f(2) == fCompose1(2))
    println(f(2) == fCompose2(2))
  }
}
