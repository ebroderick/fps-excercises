package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/10/16.
  */
class Exercise1012 {
  trait Foldable[F[_]] {
    def foldRight[A,B](as: F[A])(z: B)(f: (A,B) => B): B
    def foldLeft[A,B](as: F[A])(z: B)(f: (B,A) => B): B
    def foldMap[A,B](as: F[A])(f: A => B)(mb: Monoid[B]): B
    def concatenate[A](as: F[A])(m: Monoid[A]): A =
      foldLeft(as)(m.zero)(m.op)

    //exercise 10.15
    def toList[A](fa: F[A]): List[A] =
      foldLeft(fa)(List[A]())((b, a) => a :: b)
  }

  def foldableList = new Foldable[List] {
      override def foldRight[A, B](as: List[A])(z: B)(f: (A, B) => B): B =
        as.foldRight(z)(f)
      override def foldLeft[A, B](as: List[A])(z: B)(f: (B, A) => B): B =
        as.foldLeft(z)(f)
      override def foldMap[A, B](as: List[A])(f: (A) => B)(mb: Monoid[B]): B =
        as.foldRight(mb.zero)((a, b) => mb.op(f(a), b))
    }

  def foldableIndexedSeq = new Foldable[IndexedSeq] {
    override def foldRight[A, B](as: IndexedSeq[A])(z: B)(f: (A, B) => B): B =
      as.foldRight(z)(f)
    override def foldLeft[A, B](as: IndexedSeq[A])(z: B)(f: (B, A) => B): B =
      as.foldLeft(z)(f)
    override def foldMap[A, B](as: IndexedSeq[A])(f: (A) => B)(mb: Monoid[B]): B =
      as.foldRight(mb.zero)((a, b) => mb.op(f(a), b))
  }

}
