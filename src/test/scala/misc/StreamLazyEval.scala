package misc

/**
 * Created by brodericke on 12/2/14.
 */
object StreamLazyEval {

  sealed trait Stream[+A] {
    def toList: List[A] = this match {
      case Empty => Nil
      case Cons(h, t) => println("toList forcing h() and t()"); h() :: t().toList
    }

    def foldRight[B](caller: String, z: => B)(f: (A, => B) => B): B = this match {
      case Cons(h,t) =>
        println(s"foldRight calling f for $caller");
        f( {println(s"evaluating h() for $caller"); h()}, { println(s"evaluating t() for $caller"); t().foldRight(caller, z)(f) })
      case _ => z
    }

    def map[B](f: A => B): Stream[B] = {
      println("map calling foldRight")
      foldRight("map function", Stream[B]())((a, b) => {
        println("map creating Cons"); Stream.cons(f(a), b)
      })
    }

    def filter(f: A => Boolean): Stream[A] = {
      println("filter calling foldRight")
      foldRight("filter function", Stream[A]())((a, b) => if (f(a))  { println("filter creating Cons"); Stream.cons(a, b)} else { println("filter skipping element"); b })
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


  def main(args: Array[String]) {

    val s = Stream.cons({ println("forced 1"); 1 }, Stream.cons({ println("forced 2"); 2 }, Stream.empty[Int]))

    val mapFn = (i: Int) => {
      val result = i + 10;
      println(s"mapped $i to $result");
      result
    }

    val filterFn = (i: Int) => {
      val result = i % 2 == 0;
      println(s"filter including $i - $result");
      result
    }

    s.map(mapFn).filter(filterFn)//.toList
  }

  /**
   * 1. map method gets invoked
   *
   * 2. map calls foldRight, nothing evaluated
   *
   * 3. foldRight starts working through the stream, calls f where the next element in the stream is non-strict
   *      - the a param to f is forced ('h()') prior to calling f (the a param in f is not declared as lazy...)
   *      - the b param to f ('t().foldRight(z)(f)') is not evaluated when foldRight's f function is called
   *    not evaluating the b param is what prevents the rest of the stream from being processed
   *
   * 4. foldRight's f function is 'Stream.cons(f(a), b)' from the map method. both params to Stream.cons are lazy,
   *    so f(a) is not evaluated yet. f(a) is 'i + 10' from where map was called
   *
   * 5. the call to map returns at this point - no other elements in the stream were touched, f wasn't actually
   *    evaluated
   *
   * 6. filter method gets invoked, calls foldRight, nothing evaluated yet
   *
   * 7. foldRight calls f, forcing h, which causes the map function to finally evaluate. the result is cached in the
   *    lazy val from the smart constructor
   *
   * 8. f from filter is called with h, returns false. the else block from the filter function evaluates b. b at this
   *    point is the tail of the cons cell for the filter function: t().foldRight(caller, z)(f)
   *
   *
   */

}
