package chapter05

/**
 * Created by brodericke on 9/9/14.
 */
object Excercise0513 {
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

    def map[B](f: A => B): Stream[B] =
      Stream.unfold(this) {
        case Cons(h, t) => Some(f(h()), t())
        case Empty => None
      }

    def takeWithUnfold(i: Int): Stream[A] =
      Stream.unfold((i, this)) { (z: (Int, Stream[A])) =>
        z._2 match {
          case Cons(h, t) => if (z._1 > 0) Some(h(), (z._1 - 1, t())) else None
          case Empty => None
        }
      }

    def takeWhile(f: A => Boolean): Stream[A] =
      Stream.unfold(this) {
        case Cons(h, t) => if (f(h())) Some(h(), t()) else None
        case Empty => None
      }

    def zipAll[B](s2: Stream[B]): Stream[(Option[A],Option[B])] = {
      Stream.unfold((this, s2)) { (ss: (Stream[A], Stream[B])) =>
        ss._1 match {
          case Cons(h, t) => ss._2 match {
            case Cons(h2, t2) => Some((Some(h()), Some(h2())), (t(), t2()))
            case Empty => Some((Some(h()), None), (t(), Empty))
          }
          case Empty => ss._2 match {
            case Cons(h2, t2) => Some((None, Some(h2())), (Empty, t2()))
            case Empty => None
          }
        }
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

    /**
    def zipWith[A](as1: List[A], as2: List[A])(f: (A, A) => A): List[A] = {
      as1 match {
        case Nil => Nil
        case Cons(a1Head, a1Tail) => as2 match {
          case Nil => Nil
          case Cons(a2Head, a2Tail) => Cons(f(a1Head, a2Head), zipWith(a1Tail, a2Tail)(f))
        }
      }
    }*/

    def zipWith[A](s1: Stream[A], s2: Stream[A])(f: (A, A) => A): Stream[A] =
      unfold((s1, s2)) { (ss: (Stream[A], Stream[A])) =>
        ss._1 match {
          case Cons(h, t) => ss._2 match {
            case Cons(h2, t2) => Some(f(h(), h2()), (t(), t2()))
            case Empty => None
          }
          case Empty => None
        }
      }
  }

}
