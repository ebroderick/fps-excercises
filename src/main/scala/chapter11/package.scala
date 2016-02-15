/**
  * Created by ebroderick on 2/12/16.
  */

import language.higherKinds

package object chapter11 {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]

    def distribute[A, B](fab: F[(A, B)]): (F[A], F[B]) =
      (map(fab)(_._1), map(fab)(_._2))

    def codistribute[A, B](e: Either[F[A], F[B]]): F[Either[A, B]] =
      e match {
        case Right(fa) => map(fa)(Right(_))
        case Left(fb) => map(fb)(Left(_))
      }
  }

  val listFunctor = new Functor[List] {
    def map[A, B](as: List[A])(f: (A) => B): List[B] = as map f
  }

  trait Monad[F[_]] extends Functor[F] {
    def unit[A](a: A): F[A]
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B]

    def map[A, B](fa: F[A])(f: A => B): F[B] =
      flatMap(fa)(a => unit(f(a)))

    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
      flatMap(fa)(a => map(fb)(b => f(a, b)))

    //exercise 11.3
    def sequence[A](lfa: List[F[A]]): F[List[A]] =
      //lfa.foldRight(unit(List[A]()))((fa, acc) => flatMap(fa)(a => map(acc)(l => a :: l)))
      lfa.foldRight(unit(List[A]()))((fa, acc) => map2(fa, acc)(_ :: _))

    def traverse[A, B](la: List[A])(f: A => F[B]): F[List[B]] =
      //la.foldRight(unit(List[B]()))((a, acc) => flatMap(f(a))(b => map(acc)(l => b :: l)))
      la.foldRight(unit(List[B]()))((a, acc) => map2(f(a), acc)(_ :: _))

    //exercise 11.4
    def replicateM[A](n: Int, ma: F[A]): F[List[A]] =
      if (n == 0) {
        unit(List[A]())
      } else {
        map2(ma, replicateM(n - 1, ma))(_ :: _)
      }

    def product[A, B](ma: F[A], mb: F[B]): F[(A, B)] =
      map2(ma, mb)((_, _))

    //exercise 11.6
    def filterM[A](ms: List[A])(f: A => F[Boolean]): F[List[A]] =
      ms.foldLeft(unit(List[A]()))((acc, a) => {
        val fb = map(f(a))(if (_) List(a) else List())
        map2(acc, fb)(_ ++ _)
      })

    //exercise 11.7
    def compose[A, B, C](f: A => F[B], g: B => F[C]): A => F[C] =
      a => flatMap(f(a))(b => g(b))

    //exercise 11.8
    def flatMapViaCompose[B, C](fa: F[B])(f: B => F[C]): F[C] =
      //compose[Option[_], B, C](a => fa, f)(None)
      compose((_: Unit) => fa, f)(())

    //exercise 11.12
    def join[A](mma: F[F[A]]): F[A] =
      flatMap(mma)(identity)

    //exercise 11.13
    def flatMapViaJoinAndMap[A, B](fa: F[A])(f: A => F[B]) =
      join(map(fa)(f))
  }

  def main(args: Array[String]) {
    val m = new Monad[List] {
      override def unit[A](a: A): List[A] = List(a)
      override def flatMap[A, B](fa: List[A])(f: (A) => List[B]): List[B] = fa.flatMap(f)
    }

    //println(m.filterM(List(1, 2, 3, 4, 5))(i => List(i % 2 == 0)))

    //println(m.flatMapViaCompose(List(1))(i => List(i + 1)))

    //println(m.join(List(List(2))))

    println(m.flatMapViaJoinAndMap(List(1))(i => List(i + 1)))
  }
}
