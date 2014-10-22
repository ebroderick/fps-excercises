package chapter04

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0403 {

  /*
  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a match {
      case Some(aVal) => b match {
        case Some(bVal) => Some(f(aVal, bVal))
        case None => None
      }
      case None => None
    }
  }*/

  def map2[A,B,C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] = {
    a.flatMap(x => b.flatMap(y => Some(f(x,y))))
  }

}
