package chapter06

/**
 * Created by brodericke on 12/23/14.
 */
object Excercise0610 {

  case class State[S,+A](run: S => (A,S)) {
    def map[B](f: A => B): State[S, B] = State((s: S) => {
      val (a, s2) = run(s)
      (f(a), s2)
    })
    def flatMap[B](f: A => State[S, B]): State[S, B] = State(s => {
      val (a, s1) = run(s)
      f(a).run(s1)
    })
  }

  object State {
    def unit[A, S](a: A): State[S, A] = State(s => (a, s))
    def map2[A, B, C, S](sa: State[S, A], sb: State[S, B])(f: (A, B) => C): State[S, C] = State((s: S) => {
      val (a, s1) = sa.run(s)
      val (b, s2) = sb.run(s1)
      (f(a, b), s2)
    })
    def sequence[S, A](fs: List[State[S, A]]): State[S, List[A]] = State(s => {
      fs.foldLeft((List[A](), s))((b, state) => {
        val (list, currentState) = b
        val (a, nextState) = state.run(currentState)
        (list :+ a, nextState)
      })
    })
  }



 /*
 def sequence[A](fs: List[Rand[A]]): Rand[List[A]] = {
    rng => fs.foldLeft((List[A](), rng))((b, randA) => {
      val (list, lastRng) = b
      val (a, nextRng) = randA(lastRng)
      (list :+ a, nextRng)
    })
  }

 def flatMap[A,B](f: Rand[A])(g: A => Rand[B]): Rand[B] = {
    rng => {
      val (a, nextRng) = f(rng)
      g(a)(nextRng)
    }
  }

  def map[A,B](s: Rand[A])(f: A => B): Rand[B] =
    rng => {
      val (a, rng2) = s(rng)
      (f(a), rng2)
    }

  def mapWithFlatMap[A,B](s: Rand[A])(f: A => B): Rand[B] =
    flatMap(s)(a => RNG.unit(f(a)))


  def map2[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] = {
    rng => {
      val (a, r1) = ra(rng)
      val (b, r2) = rb(r1)
      (f(a, b), r2)
    }
  }

  def map2WithFlatMap[A,B,C](ra: Rand[A], rb: Rand[B])(f: (A, B) => C): Rand[C] =
    flatMap(ra)(a => flatMap(rb)(b => RNG.unit(f(a, b))))*/
}
