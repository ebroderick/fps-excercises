package chapter04

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0407 {

  /*
  def sequence[A](a: List[Option[A]]): Option[List[A]] = {
    a match {
      case Nil => Some(Nil)
      case x :: xs => x.flatMap(x => sequence(xs).map(x :: _))
    }
  }

  def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = {
    a match {
      case Nil => Some(Nil)
      case x :: xs => f(x).flatMap((b: B) => traverse(xs)(f).map(b :: _))
    }
  }
  */

  def sequence[E, A](es: List[Either[E, A]]): Either[E, List[A]] = {
    es match {
      case Nil => Right(Nil)
      case x :: xs => x.flatMap(x => sequence(xs).map(x :: _))
    }
  }

  def traverse[E, A, B](as: List[A])(f: A => Either[E, B]): Either[E, List[B]] = {
    as match {
      case Nil => Right(Nil)
      case x :: xs => f(x).flatMap((b: B) => traverse(xs)(f).map(b :: _))
    }
  }
}

