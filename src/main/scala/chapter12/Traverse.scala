package chapter12

import StateUtil._
import chapter06.Exercise0610.State
import chapter11.Functor

/**
  * Created by evan on 3/16/16.
  */
trait Traverse[F[_]] extends Functor[F] {
  def traverse[G[_]: Applicative, A, B](fa: F[A])(f: A => G[B]): G[F[B]] =
    sequence(map(fa)(f))
  def sequence[G[_]: Applicative, A](fga: F[G[A]]): G[F[A]] =
    traverse(fga)(ga => ga)

  def map[A,B](fa: F[A])(f: A => B): F[B] = {
    traverse[Id, A, B](fa)(f)(idMonad)
  }

  type Id[A] = A
  val idMonad = new Monad[Id] {
    def unit[A](a: => A) = a
    override def flatMap[A,B](a: A)(f: A => B): B = f(a)
  }

  def traverseS[S, A, B](fa: F[A])(f: A => State[S, B]): State[S, F[B]] =
    traverse[({type f[x] = State[S, x]})#f, A, B](fa)(f)//(Monad.stateMonad)

  def mapAccum[S, A, B](fa: F[A], s: S)(f: (A, S) => (B, S)): (F[B], S) =
    traverseS(fa)((a: A) => (for {
      s1 <- get[S]
      (b, s2) = f(a, s1)
      _ <- set(s2)
    } yield b)).run(s)

  def toList[A](fa: F[A]): List[A] =
    mapAccum(fa, List[A]())((a, s) => ((), a :: s))._2.reverse

  //exercise 12.16
  def reverse[A](fa: F[A]): F[A] =
    //mapAccum(fa, List[A]())((a, s) => ((), a :: s))
    mapAccum(fa, toList(fa).reverse)((_, as) => (as.head, as.tail))._1
}


// The `get` and `set` functions on `State` are used above,
// but aren't in the `exercises` subproject, so we include
// them here
object StateUtil {
  def get[S]: State[S, S] =
    State(s => (s, s))
  def set[S](s: S): State[S, Unit] =
    State(_ => ((), s))
}

//Exercise 12.13
object TraverseExamples {
  def listTraverse: Traverse[List] = new Traverse[List] {
    override def traverse[G[_]: Applicative, A, B](fa: List[A])(f: (A) => G[B]) : G[List[B]] = {
      val G: Applicative[G] = implicitly[Applicative[G]]
      fa.foldRight(G.unit(List[B]()))((a, gbs) => G.map2(f(a), gbs)(_ :: _))
    }
  }

  def optionTraverse: Traverse[Option] = new Traverse[Option] {
    override def traverse[G[_] : Applicative, A, B](fa: Option[A])(f: (A) => G[B]): G[Option[B]] = {
      val G: Applicative[G] = implicitly[Applicative[G]]
      fa match {
        case Some(a) => G.map(f(a))(Some(_))
        case None => G.unit(None)
      }
    }
  }

  case class Tree[+A](head: A, tail: List[Tree[A]])
  def treeTraverse: Traverse[Tree] = new Traverse[Tree] {
    override def traverse[G[_] : Applicative, A, B](fa: Tree[A])(f: (A) => G[B]): G[Tree[B]] = {
      val G: Applicative[G] = implicitly[Applicative[G]]
      val gb: G[B] = f(fa.head)
      val gltb: G[List[Tree[B]]] =
        fa.tail.foldRight(G.unit(List[Tree[B]]()))((ta, gltb) => {
          val gtb: G[Tree[B]] = traverse(ta)(f)
          G.map2(gtb, gltb)(_ :: _)
        })

      //from treeTraverseAnswer below
      val gltb2: G[List[Tree[B]]] =
        listTraverse.traverse(fa.tail)(a => traverse(a)(f))

      G.map2(gb, gltb)(Tree(_, _))
    }
  }

  val treeTraverseAnswer = new Traverse[Tree] {
    override def traverse[G[_], A, B](ta: Tree[A])(f: A => G[B])(implicit G: Applicative[G]): G[Tree[B]] =
      G.map2(f(ta.head), listTraverse.traverse(ta.tail)(a => traverse(a)(f)))(Tree(_, _))
  }
}

