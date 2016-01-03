import java.util.concurrent.TimeUnit

/**
  * @author brodericke
  */
package object chapter07 {

  type Par[A] = ExecutorService => Future[A]

  object Par {
    def unit[A](a: A): Par[A] = (es: ExecutorService) => UnitFuture(a)
    def get[A](a: Par[A]): A = ???

    def map2[A, B, C](p1: Par[A], p2: Par[B])(f: (A, B) => C): Par[C] = (es: ExecutorService) => {
      val af = p1(es)
      val bf = p2(es)
      UnitFuture(f(af.get, bf.get))
    }

    def map[A, B](p: Par[A])(f: A => B): Par[B] = map2(p, unit(()))((a, _) => f(a))

    def fork[A](a: => Par[A]): Par[A] = (es: ExecutorService) => {
      es.submit(new Callable[A] {
        def call = a(es).get
      })
    }

    def lazyUnit[A](a: => A): Par[A] = fork(unit(a))

    def run[A](a: Par[A]): A = ???
    def run2[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)

    private case class UnitFuture[A](get: A) extends Future[A] {
      override def get(timeout: Long, unit: TimeUnit): A = get
      override def isCancelled: Boolean = false
      override def cancel(evenIfRunning: Boolean): Boolean = false
      override def isDone: Boolean = true
    }

    def asyncF[A,B](f: A => B): A => Par[B] = a => lazyUnit(f(a))

    def sequence[A](ps: List[Par[A]]): Par[List[A]] =
      ps.foldRight(unit(List[A]()))((p, l) => map2(p, l)((a, b) => a :: b))

    def parMap[A,B](ps: List[A])(f: A => B): Par[List[B]] = fork {
      val fbs: List[Par[B]] = ps.map(asyncF(f))
      sequence(fbs)
    }

    def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = {
      val pars: List[Par[List[A]]] =
        as map (asyncF((a: A) => if (f(a)) List(a) else List()))
      map(sequence(pars))(_.flatten) // convenience method on `List` for concatenating a list of lists
    }
  }

  def sum(ints: IndexedSeq[Int]): Int =
    if (ints.size <= 1)
      ints.headOption.getOrElse(0)
    else {
      val (l, r) = ints.splitAt(ints.length / 2)
      val sumL: Par[Int] = Par.unit(sum(l))
      val sumR: Par[Int] = Par.unit(sum(r))
      Par.get(sumL) + Par.get(sumR)
    }

  def sum2(ints: IndexedSeq[Int]): Par[Int] =
    if (ints.size <= 1)
      Par.unit(ints.headOption.getOrElse(0))
    else {
      val (l, r) = ints.splitAt(ints.length / 2)
      Par.map2(sum2(l), sum2(r))(_ + _)
    }

  def sum3(ints: IndexedSeq[Int]): Par[Int] =
    if (ints.size <= 1)
      Par.unit(ints.headOption.getOrElse(0))
    else {
      val (l, r) = ints.splitAt(ints.length / 2)
      Par.map2(Par.fork(sum3(l)), Par.fork(sum3(r)))(_ + _)
    }


  class ExecutorService {
    def submit[A](a: Callable[A]): Future[A] = ???
  }
  trait Callable[A] { def call: A }
  trait Future[A] {
    def get: A
    def get(timeout: Long, unit: TimeUnit): A
    def cancel(evenIfRunning: Boolean): Boolean
    def isDone: Boolean
    def isCancelled: Boolean
  }
}
