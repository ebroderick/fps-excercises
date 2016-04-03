package chapter12

import language.reflectiveCalls

/**
  * Created by evan on 3/2/16.
  */
object EitherMonad {
  //exercise 12.5
  def eitherMonad[E]: Monad[({type f[x] = Either[E, x]})#f] =
    new Monad[({type f[x] = Either[E, x]})#f] {

      def unit[A](a: => A): Either[E, A] = Right(a)

      override def apply[A, B](fab: Either[E, (A) => B])(fa: Either[E, A]): Either[E, B] =
        fa match {
          case Right(a) => fab match {
            case Right(f) => Right(f(a))
            case Left(e) => Left(e)
          }
          case Left(e) => Left(e)
        }

      override def join[A](ffa: Either[E, Either[E, A]]): Either[E, A] =
        ffa match {
          case Right(re) => re match {
            case Right(a) => Right(a)
            case Left(e) => Left(e)
          }
          case Left(e) => Left(e)
        }

      override def map[A, B](fa: Either[E, A])(f: (A) => B): Either[E, B] =
        fa match {
          case Right(a) => Right(f(a))
          case Left(e) => Left(e)
        }

      override def flatMap[A, B](fa: Either[E, A])(f: (A) => Either[E, B]): Either[E, B] =
          fa match {
            case Right(a) => f(a)
            case Left(e) => Left(e)
          }
    }
}
