package chapter04

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0406 {

  sealed trait Either[+E, +A] {
    def map[B](f: A => B): Either[E, B] = this match {
      case Right(a) => Right(f(a))
      case Left(e) => Left(e)
    }

    def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
      case Right(a) => f(a)
      case Left(e) => Left(e)
    }

    def orElse[EE >: E,B >: A](b: => Either[EE, B]): Either[EE, B] = this match {
      case Right(a) => Right(a)
      case Left(e) => b
    }

    def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C): Either[EE, C] = flatMap(a => b.map(bb => f(a, bb)))
  }

  case class Left[+E](value: E) extends Either[E, Nothing]
  case class Right[+A](value: A) extends Either[Nothing, A]

  def Try[A](a: => A): Either[Exception, A] =
    try Right(a)
    catch { case e: Exception => Left(e) }
}
