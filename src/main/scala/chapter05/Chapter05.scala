package chapter05

/**
  * Created by brodericke on 11/30/15.
  */
object Chapter05 {

  sealed trait Stream[+A] {

    def toList: List[A] = this match {
      case Empty => Nil
      case Cons(h, t) => h() :: t().toList
    }

    def take(n: Int): Stream[A] = this match {
      case Cons(x, xs) if n > 0 => Stream.cons(x(), xs().take(n - 1))
      case _ => Empty
    }

    def drop(n: Int): Stream[A] = this match {
      case Cons(_, t) if n > 0 => t().drop(n - 1)
      case _ => this
    }

    def takeWhile(p: A => Boolean): Stream[A] = this match {
      case Cons(x, xs) if p(x()) => Stream.cons(x(), xs().takeWhile(p))
      case _ => Empty
    }

    def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
      case Cons(h,t) => f(h(), t().foldRight(z)(f))
      case _ => z
    }

    def forAll(p: A => Boolean): Boolean = foldRight(true)((a, b) => p(a) && b)

    def takeWhileViaFoldRight(p: A => Boolean): Stream[A] =
      foldRight(Empty: Stream[A])((a, b) => if (p(a)) Stream.cons(a, b) else Empty)

    def headOption(): Option[A] = foldRight(None: Option[A])((a, b) => Some(a))

    def map[B](f: A => B): Stream[B] = foldRight(Empty: Stream[B])((a, b) => Stream.cons(f(a), b))

    def append[B>:A](s: => Stream[B]): Stream[B] = foldRight(s)((a, b) => Stream.cons(a, b))

    def filter(p: A => Boolean): Stream[A] = foldRight(Empty: Stream[A])((a, b) => if (p(a)) Stream.cons(a, b) else b)

    def flatMap[B](f: A => Stream[B]): Stream[B] = foldRight(Empty: Stream[B])((a, b) => f(a).append(b))

    def mapViaUnfold[B](f: A => B): Stream[B] = Stream.unfold(this) {
      case Cons(x, xs) => Some((f(x()), xs()))
      case Empty => None
    }

    def takeViaUnfold(i: Int): Stream[A] = Stream.unfold((0, this))(n => n._2 match {
      case Cons(x, xs) => if (n._1 < i) Some((x(), (n._1 + 1, xs()))) else None
      case Empty => None
    })

    def takeWhileViaUnfold(p: A => Boolean) = Stream.unfold(this) {
      case Cons(x, xs) => if (p(x())) Some((x(), xs())) else None
      case Empty => None
    }

    def zipAll[B](s2: Stream[B]): Stream[(Option[A],Option[B])] = Stream.unfold((this, s2)) {
      case (Empty, Empty) => None
      case (Cons(x, xs), Empty) => Some((Some(x()), None), (xs(), Empty))
      case (Empty, Cons(y, ys)) => Some((None, Some(y())), (Empty, ys()))
      case (Cons(x, xs), Cons(y, ys)) => Some((Some(x()), Some(y())), (xs(), ys()))
    }

    def zipWith[B, C](s2: Stream[B])(f: (A, B) => C): Stream[C] = Stream.unfold((this, s2)) {
      case (_, Empty) => None
      case (Empty, _) => None
      case (Cons(x, xs), Cons(y, ys)) => Some(f(x(), y()), (xs(), ys()))
    }

    def zip[B](s2: Stream[B]): Stream[(A,B)] =
      zipWith(s2)((_,_))

    @annotation.tailrec
    final def find(f: A => Boolean): Option[A] = this match {
      case Empty => None
      case Cons(h, t) => if (f(h())) Some(h()) else t().find(f)
    }

    def startsWith[B>:A](s: Stream[B]): Boolean = zipAll(s).takeWhile(_._2.isDefined).forAll(t => t._1 == t._2)

    def tails(): Stream[Stream[A]] = Stream.unfold(this)(s => s match {
      case Cons(x, xs) => Some(s, xs())
      case Empty => None
    })
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

    def constant[A](a: A): Stream[A] = Stream.cons(a, constant(a))

    def from(i: Int): Stream[Int] = Stream.cons(i, from(i + 1))

    def fibs(): Stream[Int] = {
      def go(p: Int, p2: Int): Stream[Int] = Stream.cons(p + p2, go(p + p2, p))
      Stream.cons(0, Stream.cons(1, go(1, 0)))
    }

    def unfold[A, S](z: S)(f: S => Option[(A, S)]): Stream[A] = f(z) match {
      case Some((a, s)) => Stream.cons(a, unfold(s)(f))
      case None => Stream.empty
    }

    def fibsViaUnfold(): Stream[Int] = unfold((0, 1))(t => Some((t._1, (t._2, t._1 + t._2))))

    def fromViaUnfold(i: Int): Stream[Int] = unfold(i)(x => Some((x, x + 1)))

    def constantViaUnfold(i: Int): Stream[Int] = unfold(i)(x => Some((x, x)))
  }
}
