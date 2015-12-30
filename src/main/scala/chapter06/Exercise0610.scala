package chapter06

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0610 {

  case class State[S,+A](run: S => (A,S)) {

    def flatMap[B](f: A => State[S, B]): State[S, B] = State(s => {
      val (a, s2) = run(s)
      f(a).run(s2)
    })

    def map[B](f: A => B): State[S, B] = flatMap(a => State.unit(f(a)))

    def map2[B, C](bs: State[S, B])(f: (A, B) => C): State[S, C] =
      flatMap(a => bs.map(b => f(a, b)))


  }

  object State {

    def unit[A, S](a: A): State[S, A] = State(s => (a, s))

    def sequence[A, S](l: List[State[S, A]]): State[S, List[A]] =
      l.foldRight(State.unit(List[A]()): State[S, List[A]])((s, acc) => s.map2(acc)(_ :: _))

    def modify[S](f: S => S): State[S, Unit] = for {
      s <- get // Gets the current state and assigns it to `s`.
      _ <- set(f(s)) // Sets the new state to `f` applied to `s`.
    } yield ()

    def get[S]: State[S, S] = State(s => (s, s))

    def set[S](s: S): State[S, Unit] = State(_ => ((), s))
  }
}
