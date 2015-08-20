package chapter06

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner
import org.scalatest.BeforeAndAfter
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._

/**
 * Created by brodericke on 12/23/14.
 */
@RunWith(classOf[JUnitRunner])
class Excercise0601TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

  test("test non-negative int") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((-1, mockRng))

    val (result1, rng1) = chapter06.Excercise0601.nonNegativeInt(mockRng)
    assert(result1 == 1)

    when(mockRng.nextInt).thenReturn((1, mockRng))

    val (result2, rng2) = chapter06.Excercise0601.nonNegativeInt(mockRng)
    assert(result2 == 1)

    when(mockRng.nextInt).thenReturn((Int.MinValue, mockRng))

    val (result3, rng3) = chapter06.Excercise0601.nonNegativeInt(mockRng)
    println(result3)
    assert(result3 > 0)
  }

}
