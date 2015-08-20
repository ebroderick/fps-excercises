package chapter06

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by brodericke on 12/23/14.
 */
@RunWith(classOf[JUnitRunner])
class Excercise0610TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

  import Excercise0610._

  test("test unit") {
    val state = State((s: Int) => (-s, s + 1))
    assert(state.run(1) == (-1, 2))

    val state2: State[Int, Int] = State.unit(4)
    assert(state2.run(2) == (4, 2))
  }

  test("test map") {
    val state = State((s: Int) => (-s, s + 1))
    assert(state.map(i => -i).run(1) == (1, 2))
  }

  test("test map2") {
    val state1 = State((s: Int) => (-s, s + 1))
    val state2 = State((s: Int) => (s * 2, s + 1))

    assert(State.map2(state1, state2)((i1, i2) => i1 + i2).run(2) == (4, 4))
  }

  test("test flatMap") {
    val state = State((s: Int) => (-s, s + 1))

    assert(state.flatMap((a: Int) => State.unit(a + 4)).run(2) == (2, 3))
  }
}
