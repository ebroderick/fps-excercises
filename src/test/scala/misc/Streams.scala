package misc

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Streams extends FunSuite {
  import Streams._

  test("map") {

    println("Creating stream")
    val s = Stream.cons({println("  evaluating head of stream"); 1}, Stream.cons({println("  evaluating 2nd item of stream"); 2}, Empty))
    println("Created stream\n")

    /*
    map calls foldRight starting with non-strict empty stream
    - foldRight matches Cons(1, Stream(2)) and map function is called.
        - head (value of 1) is evaluated since first param to the function passed to flatMap is strict
        - tail expression, which has the recursive call, is not evaluated
    - foldRight function is applied (defined back in the actual map method), which passes f(a) and the tail expression
      to cons as non-strict params
        - neither f(a) or the recursive call in the tail expression are evaluated at this point and the initial call
          to map should return
     */
    println("Mapping stream")
    val m = s.map(i => { println(s"  applying map function, arg $i"); i.toString } )
    println("Mapped stream\n")

    /*
    toList matches Cons(h, t) and
      1. h is evaluated. h was initially passed into Stream.cons as a non-strict param in the function passed to
         foldRight in the map method. The function passed to the map method will now be applied to head, turning 1 into
         "1"
      2. t is evaluated. t was defined in the foldRight method and includes the recursive call to foldRight. The
         function passed to foldRight is non-strict in the 2nd parameter, and the function passed to map is also using
         it as a non-strict parameter.
     */
    println("Stream.toList")
    m.toList
  }
}


object Streams {

  sealed trait Stream[+A] {

    def toList: List[A] = this match {
      case Empty => Nil
      case Cons(h, t) => {
        println("  evaluating head in toList")
        val x = h()
        println(s"  evaluated head in toList: $x")
        println("  evaluating tail in toList")
        val s = t()
        println("  recursive call to toList")
        x :: s.toList
      }
    }

    def foldRight[B](z: => B)(f: (A, => B) => B): B = this match {
      case Cons(h,t) => f(h(), {
        println("  evaluating tail expression in foldRight");
        val tail = t();
        println("  evaluated tail");
        tail.foldRight(z)(f)
      })
      case _ => z
    }

    def map[B](f: A => B): Stream[B] = foldRight(Empty: Stream[B])((a, b) => Stream.cons(f(a), b))
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