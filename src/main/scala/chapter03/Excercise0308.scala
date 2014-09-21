package chapter03

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0308 {
  def foldRight[A,B](as: List[A], z: B)(f: (A, B) => B): B = {
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }
  }

  def main(args: Array[String]) {
    //similar to List.apply
    println(foldRight(List(1,2,3), Nil: List[Int])(Cons(_,_)))
  }
}
