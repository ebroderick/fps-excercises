package chapter05

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0510 {
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

    def fibs: Stream[Int] = {
      def fibs(iMinus2: Int, iMinus1: Int): Stream[Int] = {
        val currentNumber = iMinus2 + iMinus1
        Stream.cons(currentNumber, fibs(iMinus1, currentNumber))
      }

      Stream.cons(0, Stream.cons(1, fibs(0, 1)))
    }
  }

}
