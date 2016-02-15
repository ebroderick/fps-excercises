package chapter11

/**
  * Created by ebroderick on 2/15/16.
  */
object Exercise1117 {

  case class Id[A](value: A) {
    def flatMap[B](f: A => Id[B]): Id[B] = f(value)
    def map[B](f: A => B): Id[B] = flatMap(a => Id(f(a)))
  }

  val idMonad = new Monad[Id] {
    def unit[A](a: A): Id[A] = Id(a)
    def flatMap[A, B](fa: Id[A])(f: (A) => Id[B]): Id[B] = fa.flatMap(f)
  }
}
