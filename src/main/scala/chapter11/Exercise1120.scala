package chapter11

/**
  * Created by ebroderick on 2/15/16.
  */
object Exercise1120 {

  case class Reader[R, A](run: R => A)

  object Reader {
    def readerMonad[R] = new Monad[({type f[x] = Reader[R, x]})#f] {
      def unit[A](a: A): Reader[R, A] = Reader(r => a)
      def flatMap[A, B](fa: Reader[R, A])(f: (A) => Reader[R, B]): Reader[R, B] =
        Reader(r => f(fa.run(r)).run(r))

      //given an R, fa reader gets run with R, result gets passed to F. then
      //same R value is run against the result of F
    }
  }
}
