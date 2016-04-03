package chapter12

/**
  * Created by evan on 3/2/16.
  */
object ValidationApplicative {
  sealed trait Validation[+E, +A]

  case class Failure[E](head: E, tail: Vector[E] = Vector())
    extends Validation[E, Nothing]

  case class Success[A](a: A) extends Validation[Nothing, A]

  //exercise 12.6
  def validationApplicative[E]: Applicative[({type f[x] = Validation[E,x]})#f] =
    new Applicative[({type f[x] = Validation[E,x]})#f] {

      override def map2[A, B, C](fa: Validation[E, A], fb: Validation[E, B])(f: (A, B) => C): Validation[E, C] =
        /*fa match {
          case Success(a) => fb match {
            case Success(b) => Success(f(a, b))
            case Failure(h, t) => Failure(h, t)
          }
          case Failure(h, t) => fb match {
            case Success(b) => Failure(h, t)
            case Failure(h2, t2) => Failure(h2, h +: (t ++ t2))
          }
        }*/
        (fa, fb) match {
          case (Success(a), Success(b)) => Success(f(a, b))
          case (Failure(h1, t1), Failure(h2, t2)) =>
            Failure(h2, Vector(h1) ++ t1 ++ t2)
          case (e @ Failure(_, _), _) => e
          case (_, e @ Failure(_, _)) => e
        }


      override def apply[A, B](fab: Validation[E, (A) => B])(fa: Validation[E, A]): Validation[E, B] =
        /*fab match {
          case Success(f) => fa match {
            case Success(a) => Success(f(a))
            case Failure(h, t) => Failure(h, t)
          }
          case Failure(h, t) => Failure(h, t)
        }*/
        (fab, fa) match {
          case (Success(f), Success(a)) => Success(f(a))
          case (Success(_), f @ Failure(_, _)) => f
          case (f @ Failure(_, _), _) => f
        }

      def unit[A](a: => A): Validation[E, A] = Success(a)
    }
}
