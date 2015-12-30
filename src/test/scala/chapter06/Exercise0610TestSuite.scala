package chapter06

import chapter06.Exercise0610.State
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * @author brodericke
  */
@RunWith(classOf[JUnitRunner])
class Exercise0610TestSuite  extends FunSuite {

  type Rand[A] = State[RNG, A]

  test("flatMap") {
    val rng: RNG = SimpleRNG(1)
    val rand: Rand[Int] = State(Exercise0601.nonNegativeInt)
    val randFlatMap = rand.flatMap(i => State.unit(-i))
    val (i, _) = randFlatMap.run(rng)
    assert(i <= 0)
  }

  test("map") {
    val rng: RNG = SimpleRNG(1)
    val rand: Rand[Int] = State(Exercise0608.nonNegativeLessThan(20))
    val randMap = rand.map(i => -i)
    val (i, _) = randMap.run(rng)
    assert(i < 0 && i >= -20)
  }

  test("map2") {
    val rng: RNG = SimpleRNG(1)
    val rand: Rand[Double] = State(Exercise0602.double)
    val randMap2 = rand.map2(State(Exercise0601.nonNegativeInt))((d, i) => (d, i))
    val ((d, i), _) = randMap2.run(rng)
    assert(d < 1 && i >= 0)
  }

  test("sequence") {
    val l: List[Rand[Int]] = List.fill(3)(State(Exercise0601.nonNegativeInt))
    val seq = State.sequence(l)
    val rng: RNG = SimpleRNG(1)
    val (l2, _) = seq.run(rng)
    assert(l2.size == 3)
    assert(l2.head != l2(1))
  }
}
