package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0301 {
  def main(args: Array[String]) {
    val x = List(1,2,3,4,5) match {
      case

        Cons(x, Cons(2, Cons(4, _))) => x
      case Nil => 42
      case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => println("match"); x + y
      case Cons(h, t) => h + List.sum(t)
      case _ => 101
    }
    println(x)
  }
}
