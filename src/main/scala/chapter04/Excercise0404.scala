package chapter04

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0404 {

  /*def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a.flatMap(
      x => b.flatMap(
        y => Some(f(x,y))))
  }*/

  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    a match {
      case Nil => Some(Nil)
      case x :: xs => x.flatMap(x => sequence(xs).map(x :: _))
    }
  }

}
