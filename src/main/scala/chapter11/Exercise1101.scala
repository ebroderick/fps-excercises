package chapter11

/**
  * Created by ebroderick on 2/12/16.
  */
object Exercise1101 {

  val listMonad = new Monad[List] {
    def unit[A](a: A): List[A] = List(a)
    def flatMap[A, B](fa: List[A])(f: (A) => List[B]): List[B] =
      fa flatMap f
  }

  val optionMonad = new Monad[Option] {
    def unit[A](a: A): Option[A] = Some(a)
    def flatMap[A, B](fa: Option[A])(f: (A) => Option[B]): Option[B] =
      fa flatMap f
  }
}
