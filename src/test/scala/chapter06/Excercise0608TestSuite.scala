package chapter06

import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.{BeforeAndAfter, FunSuite}
import org.scalatest.junit.JUnitRunner
import org.scalatest.mock.MockitoSugar

/**
 * Created by brodericke on 12/23/14.
 */
@RunWith(classOf[JUnitRunner])
class Excercise0608TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

  test("test non-negative int with flatmap") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((-1254125, mockRng), (4, mockRng))

    val (result1, rng1) = chapter06.Excercise0608.nonNegativeLessThanWithFlatMap(5)(mockRng)
    assert(result1 < 5 && result1 > -1)
  }

}
