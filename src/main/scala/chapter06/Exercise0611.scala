package chapter06

import chapter06.Exercise0610.State

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0611 {

  sealed trait Input
  case object Coin extends Input
  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  object Candy {
    def update = (i: Input) => (s: Machine) =>
      (i, s) match {
        case (_, Machine(_, 0, _)) => s
        case (Coin, Machine(false, _, _)) => s
        case (Turn, Machine(true, _, _)) => s
        case (Coin, Machine(true, candy, coin)) =>
          Machine(false, candy, coin + 1)
        case (Turn, Machine(false, candy, coin)) =>
          Machine(true, candy - 1, coin)
      }

    def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = for {
      _ <- State.sequence(inputs map (State.modify[Machine] _ compose update))
      s <- State.get
    } yield (s.coins, s.candies)

    def simulateMachine2(inputs: List[Input]): State[Machine, (Int, Int)] = {
      val seq = State.sequence(inputs.map(i => State.modify(update(i))))
      seq.flatMap(_ => State.get.map(s => (s.coins, s.candies)))
    }
  }

}
