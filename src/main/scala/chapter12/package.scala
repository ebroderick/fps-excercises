import scala.language.{reflectiveCalls, higherKinds}

/**
  * Created by evan on 2/29/16.
  */
package object chapter12 {

  trait Applicative[F[_]] extends chapter11.Functor[F] {
    //primitive combinators
    def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
      map2ViaUnitAndApplyAnswer(fa, fb)(f)

    def unit[A](a: => A): F[A]

    //def apply[A, B](fab: F[A => B])(fa: F[A]): F[B]

    //derived combinators
    def map[A, B](fa: F[A])(f: A => B): F[B] =
      map2(fa, unit(()))((a, _) => f(a))

    def traverse[A, B](as: List[A])(f: A => F[B]): F[List[B]] =
      as.foldRight(unit(List[B]()))((a, fbs) => map2(f(a), fbs)(_ :: _))

    //exercise 12.1
    def sequence[A](fas: List[F[A]]): F[List[A]] =
      traverse(fas)(a => a)

    //exercise 12.12
    def sequenceMap[K, V](ofa: Map[K, F[V]]): F[Map[K, V]] =
      ofa.foldRight(unit(Map[K, V]())) {
        case ((k, fv), fm) => map2(fv, fm)((v, m) => m + ((k, v)))
      }

    def replicateM[A](n: Int, fa: F[A]): F[List[A]] =
      sequence(List.fill(n)(fa))

    def product[A, B](fa: F[A], fb: F[B]): F[(A, B)] =
      map2(fa, fb)((_, _))

    //exercise 12.2
    def mapViaUnitAndApply[A, B](fa: F[A])(f: A => B): F[B] =
      apply(unit[A => B](f))(fa)

    def map2ViaUnitAndApply[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = {
      /*mapViaUnitAndApply[A, C](fa)(a => {
        val fbc: F[B => C] = unit(f(a, _))
        apply[B, C](fbc)(fb)
      })*/
      ???
    }

    def map2ViaUnitAndApplyAnswer[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] = {
      //val fc: F[B => C] = map(fa)(f.curried)
      apply[B, C](map(fa)(f.curried))(fb)
    }

    def apply[A, B](fab: F[A => B])(fa: F[A]): F[B] =
      map2(fa, fab)((a, f) => f(a))

    //exercise 12.3
    def map3[A, B, C, D](fa: F[A], fb: F[B], fc: F[C])(f: (A, B, C) => D): F[D] = {
      val fc1: A => B => C => D = f.curried
      val fbcd: F[B => C => D] = apply[A, B => C => D](unit(f.curried))(fa)
      val fcd: F[C => D] = apply[B, C => D](fbcd)(fb)
      val fd: F[D] = apply[C, D](fcd)(fc)

      apply[C, D](
        apply[B, C => D](
          apply[A, B => C => D](unit(f.curried))(fa)
        )(fb)
      )(fc)

      //this compiles just fine, but intellij shows an type error at fa:
      //apply(apply(apply(unit(f.curried))(fa))(fb))(fc)
    }

    //exercise 12.8
    def product[G[_]](G: Applicative[G]) = {
        val self = this
        new Applicative[({type f[x] = (F[x], G[x])})#f] {
          def unit[A](a: => A) = (self.unit(a), G.unit(a))
          override def apply[A,B](fs: (F[A => B], G[A => B]))(p: (F[A], G[A])) =
            (self.apply(fs._1)(p._1), G.apply(fs._2)(p._2))
        }
    }

    //exercise 12.9
    def compose[G[_]](G: Applicative[G]) = {
      val self = this
      new Applicative[({type f[x] = F[G[x]]})#f] {
        override def unit[A](a: => A): F[G[A]] = self.unit(G.unit(a))

        override def map2[A, B, C](fa: F[G[A]], fb: F[G[B]])(f: (A, B) => C): F[G[C]] = {
          val f1: F[G[B => C]] = map(fa)(f.curried)
          apply(f1)(fb)
        }
      }
    }
  }

  //monad as subtype of applicative - subtypes of monad must override either flatMap or join
  //does haskell's monad type class provide mutually dependent bind & join functions?
  trait Monad[F[_]] extends Applicative[F] {
    def flatMap[A, B](fa: F[A])(f: A => F[B]): F[B] = join(map(fa)(f))
    def join[A](ffa: F[F[A]]): F[A] = flatMap(ffa)(identity)
    def compose[A, B, C](f: A => F[B], g: B => F[C]): A => F[C] =
      //a => flatMap(f(a))(b => g(b))
      a => flatMap(f(a))(g)
    override def map[A, B](fa: F[A])(f: A => B): F[B] =
      flatMap(fa)(a => unit(f(a)))
    override def map2[A, B, C](fa: F[A], fb: F[B])(f: (A, B) => C): F[C] =
      flatMap(fa)(a => map(fb)(b => f(a, b)))
  }


}
