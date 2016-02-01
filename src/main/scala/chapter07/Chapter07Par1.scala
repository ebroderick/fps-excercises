package chapter07

/**
  * Created by ebroderick on 1/29/16.
  */
object Chapter07Par1 {

  def main(args: Array[String]) {
    lazyUnitExample();
  }

  def lazyUnitExample() {
    val e = new ExecutorService

    // calls fork, returns es => f function that submits a callable
    // to the es when executed. the e => f function returned by
    // unit(a) (which is passed to fork) is evaluated within that
    // callable, which evaluates the parameter to lazyUnit below.
    val p = Par.lazyUnit( { println("evaluated"); 1} )

    println("running p")
    val f = Par.run(e)(p) //calls es => future function p
    println(f.get)
  }

  type Par[A] = ExecutorService => Future[A]

  object Par {
    //def unit[A](a: => A): Par[A] = ???
    def unit[A](a: A): Par[A] = es => UnitFuture(a)

    //def get[A](a: Par[A]): A = ???
    //def run[A](a: Par[A]): A = ???
    def run[A](s: ExecutorService)(a: Par[A]): Future[A] = a(s)

    def fork[A](a: => Par[A]): Par[A] =
      es => {
        println("forked par invoked")
        es.submit(new Callable[A] {
          override def call: A = {
            println("evaluating 'a' param to fork in separate thread")
            val f = a
            println("calling f to get value of a")
            f(es).get
          }
        })
      }

    def lazyUnit[A](a: => A): Par[A] = fork(unit(a))

    def map2[A, B, C](pa: Par[A], pb: Par[B])(f: (A, B) => C): Par[C] =
      (es: ExecutorService) => {
        val af = pa(es)
        val bf = pb(es)
        UnitFuture(f(af.get, bf.get))
      }

    //exercise 7.4
    def asyncF[A, B](f: A => B): A => Par[B] = a => lazyUnit(f(a))

    def map[A, B](pa: Par[A])(f: A => B): Par[B] =
      map2(pa, unit(()))((a, _) => f(a))

    def mapAlt[A, B](pa: Par[A])(f: A => B): Par[B] = es => UnitFuture(f(pa(es).get))

    def sortPar(pList: Par[List[Int]]) = map(pList)(_.sorted)

    //exercise 7.5
    def sequence[A](ps: List[Par[A]]): Par[List[A]] =
      ps.foldLeft(unit(List[A]()))((pl, p) => {
        Par.map2(pl, p)((pl2, p2) => pl2 ++ List(p2))
      })

    def parMap[A, B](ps: List[A])(f: A => B): Par[List[B]] = fork {
      val fbs: List[Par[B]] = ps.map(asyncF(f))
      sequence(fbs)
    }

    //exercise 7.6
    def parFilter[A](as: List[A])(f: A => Boolean): Par[List[A]] = {
      val l: List[Par[List[A]]] = as.map(asyncF(a => if (f(a)) List(a) else List()))

      /*l.foldLeft(unit(List[A]()))((pl1, pl2) => {
        Par.map2(pl1, pl2)((x, y) => x ++ y)
      })*/

      val s: Par[List[List[A]]] = sequence(l)

      //List(List(1, 2), List(3, 4)).flatten == List(1, 2, 3, 4)
      map(s)((x: List[List[A]]) => x.flatten)
    }

    def delay[A](fa: => Par[A]): Par[A] = es => fa(es)

    //exercise 7.11
    def choiceN[A](n: Par[Int])(choices: List[Par[A]]): Par[A] = es => {
      val r = run(es)(n).get
      choices(r)(es)
    }

    def choice[A](cond: Par[Boolean])(t: Par[A], f: Par[A]): Par[A] =
      choiceN(map(cond)(if (_) 0 else 1))(List(t, f))

    //exercise 7.12
    def choiceAlt[A, B](cf: () => Par[B])(sf: B => Par[A]): Par[A] = es => {
      val b = run(es)(cf()).get
      sf(b)(es)
    }

    //exercise 7.13
    def chooser[A, B](pa: Par[A])(choices: A => Par[B]): Par[B] = es => {
      val a = run(es)(pa).get
      choices(a)(es)
    }

    def choiceViaChooser[A](test: Par[Boolean])(t: Par[A], f: Par[A]) =
      chooser(test)(if (_) t else f)

    def choiceNViaChooser[A](index: Par[Int])(l: List[Par[A]]) =
      chooser(index)(l(_))

    //exercise 7.14
    def join[A](a: Par[Par[A]]): Par[A] = es => {
      val pa = run(es)(a).get
      pa(es)
    }

    def flatMapViaJoin[A, B](pa: Par[A])(f: A => Par[B]): Par[B] = join(map(pa)(f))

    def joinViaFlatMap[A](a: Par[Par[A]]): Par[A] = flatMapViaJoin(a)(identity)
  }

  def sum(ints: IndexedSeq[Int]): Par[Int] =
    if (ints.size <= 1)
      Par.unit(ints.headOption.getOrElse(0))
    else {
      val (l, r) = ints.splitAt(ints.size / 2)

      //Par.map2(sum(l), sum(r))(_ + _)
      Par.map2(Par.fork(sum(l)), Par.fork(sum(r)))(_ + _)
    }
}
