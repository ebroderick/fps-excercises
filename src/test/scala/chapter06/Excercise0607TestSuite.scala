package chapter06

import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite}

/**
 * Created by brodericke on 12/23/14.
 */
@RunWith(classOf[JUnitRunner])
class Excercise0607TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

  test("test sequence") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((1, mockRng), (2, mockRng), (3, mockRng))

    val randList: List[Rand[Int]] = List(rng => rng.nextInt, rng => rng.nextInt, rng => rng.nextInt)

    val seq = Excercise0607.sequence(randList)

    val (list, nextRng) = seq(mockRng)
    assert(list == List(1, 2, 3))
  }

  test("test ints") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((1, mockRng), (2, mockRng), (3, mockRng))

    val seq = Excercise0607.ints(3)
    val (list, nextRng) = seq(mockRng)
    assert(list == List(1, 2, 3))
  }
}

