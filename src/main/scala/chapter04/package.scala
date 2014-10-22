/**
 * Created by brodericke on 10/16/14.
 */
package object chapter04 {

  sealed trait Option[+A] {
    def map[B](f: A => B): Option[B] = this match {
      case None => None
      case Some(a) => Some(f(a))
    }
    def flatMap[B](f: A => Option[B]): Option[B] = map(f) getOrElse None
    def getOrElse[B >: A](default: => B): B = this match {
      case None => default
      case Some(a) => a
    }
    def orElse[B >: A](ob: => Option[B]): Option[B] = this match {
      case None => ob
      case Some(a) => Some(a)
    }
    def filter(f: A => Boolean): Option[A] = this match {
      case None => None
      case Some(a) => if (f(a)) Some(a) else None
    }
  }

  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]

  sealed trait Either[+E, +A] {

    def map[B](f: A => B): Either[E, B] = this match {
      case Left(e) => Left(e)
      case Right(x) => Right(f(x))
    }

    def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B]  = this match {
      case Left(e) => Left(e)
      case Right(x) => f(x)
    }

    def orElse[EE >: E,B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
      case Left(e) => b
      case Right(x) => Right(x)
    }

    def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = {
      this flatMap (x => b flatMap (y => Right(f(x,y))))
    }
  }

  case class Left[+E](value: E) extends Either[E, Nothing]
  case class Right[+A](value: A) extends Either[Nothing, A]
}
