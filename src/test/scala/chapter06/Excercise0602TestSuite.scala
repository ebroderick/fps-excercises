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
class Excercise0602TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

   test("test double") {
     val mockRng = mock[RNG]
     when(mockRng.nextInt).thenReturn((-112412, mockRng))

     val (result1, rng1) = chapter06.Excercise0602.double(mockRng)
     assert(result1 > 0.0 && result1 < 1.0)

     when(mockRng.nextInt).thenReturn((-1, mockRng))

     val (result2, rng2) = chapter06.Excercise0602.double(mockRng)
     assert(result2 > 0.0 && result2 < 1.0)

     when(mockRng.nextInt).thenReturn((Int.MaxValue, mockRng))

     val (result3, rng3) = chapter06.Excercise0602.double(mockRng)
     assert(result3 > 0.0 && result3 < 1.0)

     when(mockRng.nextInt).thenReturn((Int.MinValue, mockRng))

     val (result4, rng4) = chapter06.Excercise0602.double(mockRng)
     assert(result4 > 0.0 && result4 < 1.0)
   }

 }
