package chapter05

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0507 {
  sealed trait Stream[+A] {
    def toList: List[A] = this match {
      case Empty => Nil
      case Cons(h, t) => h() :: t().toList
    }

    def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
      case Cons(h,t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }

    def map[B](f: A => B): Stream[B] =
      foldRight(Stream[B]())((a, b) => Stream.cons(f(a), b))

    def filter(f: A => Boolean): Stream[A] =
      foldRight(Stream[A]())((a, b) => if (f(a)) Stream.cons(a, b) else b)

    def append[B>:A](x: => Stream[B]) =
      foldRight(x)((a, b) => Stream.cons(a, b))

    def flatMap[B](f: A => Stream[B]): Stream[B] =
      foldRight(Stream[B]())((a, b) => f(a).foldRight(b)((a2, b2) => Stream.cons(a2, b2)))

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
