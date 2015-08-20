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
class Excercise0609TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

  test("test map flatmap") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((1, mockRng))

    val (result1, rng1) = chapter06.Excercise0609.mapWithFlatMap(RNG.unit(1))(a => -a)(mockRng)
    assert(result1 == -1)
  }

  test("test map2 flatmap") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((1, mockRng))

    val (result1, rng1) = chapter06.Excercise0609.map2WithFlatMap(RNG.unit(1), RNG.unit(2))((a, b) => a + b)(mockRng)
    assert(result1 == 3)
  }

}
