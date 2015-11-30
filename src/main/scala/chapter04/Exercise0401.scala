package chapter04

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0401 {

  sealed trait Option[+A] {

    def map[B](f: A => B): Option[B] = this match {
      case Some(a) => Some(f(a))
      case None => None
    }

    def getOrElse[B >: A](default: => B): B = this match {
      case Some(a) => a
      case None => default
    }

    def flatMap[B](f: A => Option[B]): Option[B] = map(f(_)).getOrElse(None)

    def orElse[B >: A](ob: => Option[B]): Option[B] = map(_ => this).getOrElse(ob)

    def filter(f: A => Boolean): Option[A] = map(a => if (f(a)) this else None).getOrElse(None)
  }

  case class Some[+A](get: A) extends Option[A]
  case object None extends Option[Nothing]
}
