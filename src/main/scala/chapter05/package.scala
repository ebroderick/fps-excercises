/**
 * Created by brodericke on 10/29/14.
 */
package object chapter05 {
  sealed trait Stream[+A] {
    def toList: List[A] = this match {
      case Empty => Nil
      case Cons(h, t) => h() :: t().toList
    }

    def take(n: Int): Stream[A] = {
      if (n == 0) Empty
      else this match {
        case Empty => Empty
        case Cons(h, t) => Stream.cons(h(), t().take(n - 1))
      }
    }

    def drop(n: Int): Stream[A] = {
      if (n == 0) this
      else this match {
        case Empty => Empty
        case Cons(h, t) => t().drop(n - 1)
      }
    }

    def takeWhile(p: A => Boolean): Stream[A] = this match {
      case Empty => Empty
      case Cons(h, t) =>
        lazy val head = h()
        if (p(head)) Stream.cons(head, t().takeWhile(p))
        else Empty
    }
  }
  case object Empty extends Stream[Nothing]
  case class Cons[+A](h: () => A, t: () => Stream[A]) extends Stream[A]

  object Stream {
    def cons[A](hd: => A, tl: => Stream[A]): Stream[A] = {
      lazy val head = hd
      lazy val tail = tl
      Cons(() => head, () => tail)
    }
    def empty[A]: Stream[A] = Empty
    def apply[A](as: A*): Stream[A] =
      if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))
  }
}
