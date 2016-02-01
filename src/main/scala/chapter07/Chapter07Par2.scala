package chapter07

import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicReference

/**
  * Created by ebroderick on 1/29/16.
  */
object Chapter07Par2 {

  def main(args: Array[String]) {
    val es = new ExecutorService

    // creates es -> f function. when called, a new future is created
    // with an apply method that takes a callback function. When apply
    // is called with a provided function, eval function gets called,
    // which submits a callable to the es - within that callable, the
    // Par.unit parameter below is finally evaluated and the callback
    // function gets called
    val p = Par.fork(Par.unit( { println("running task"); 1 }))

    //kicks off evaluation by calling apply on the future returned by
    //calling p.
    //
    // 1. p(es) - returns future created in fork function
    // 2. p(es) {block} - calls apply on that future, which calls eval
    // 3. eval(es)(r) - submits new callable to es where the call method
    //      evaluates r, which is "a(es)(cb)" from fork function
    // 4. a(es) - a is the param to fork, so param to unit is evaluated.
    //      when called with es, the future defined in unit is returned
    // 5. a(es)(cb) - when apply method is called on that future, cb
    //      function (defined in run, step 2) is executed with the
    //      evaluated param to unit
    println(Par.run(es)(p))
  }

  sealed trait Future[A] {
    def apply(k: A => Unit): Unit
  }

  type Par[A] = ExecutorService => Future[A]

  object Par {
    def run[A](es: ExecutorService)(p: Par[A]): A = {
      val ref = new AtomicReference[A]()
      val latch = new CountDownLatch(1)

      //p(es).apply(a => { ref.set(a); latch.countDown() })
      p(es) { a => ref.set(a); latch.countDown() }

      latch.await()
      ref.get
    }

    def unit[A](a: A): Par[A] =
      es => new Future[A] {
        def apply(cb: A => Unit) {
          cb(a)
        }
      }

    def fork[A](a: => Par[A]): Par[A] =
      es => new Future[A] {
        def apply(cb: A => Unit) = {
          eval(es)(a(es)(cb))
        }
      }

    def eval(es: ExecutorService)(r: => Unit) {
      es.submit(new Callable[Unit] { def call = r })
    }

    def map2[A, B, C](p: Par[A], p2: Par[B])(f: (A, B) => C): Par[C] =
      es => new Future[C] {
        override def apply(cb: (C) => Unit): Unit = {
          var ar: Option[A] = None
          var br: Option[B] = None

          val combiner = Actor[Either[A, B]](es) {
            case Left(a) => br match {
              case None => ar = Some(a)
              case Some(b) => eval(es)(cb(f(a, b)))
            }
            case Right(b) => ar match {
              case None => br = Some(b)
              case Some(a) => eval(es)(cb(f(a, b)))
            }
          }

          p(es)(a => combiner ! Left(a))
          p2(es)(b => combiner ! Right(b))
        }
      }
  }
}
