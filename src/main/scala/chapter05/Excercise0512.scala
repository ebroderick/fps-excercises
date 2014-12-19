package chapter05

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0512 {
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

    def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = {
      f(z) match {
        case Some((a, s)) => Stream.cons(a, unfold(s)(f))
        case None => Stream.empty
      }
    }

    def fibs: Stream[Int] = Stream.cons(0, Stream.cons(1, unfold((0, 1)) { (ints: (Int, Int)) =>
      Some(ints._1 + ints._2, (ints._2, ints._1 + ints._2))
    }))

    def from(i: Int): Stream[Int] = unfold(i)(x => Some(x, x + 1))

    def constant[A](a: A): Stream[A] = unfold(a)(x => Some(a, a))

    val ones: Stream[Int] = unfold(1)(x => Some(1, 1))
  }

}
