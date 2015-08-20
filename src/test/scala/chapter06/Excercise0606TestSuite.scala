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
class Excercise0606TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

   test("test map2 and both") {
     val mockRng = mock[RNG]
     when(mockRng.nextInt).thenReturn((-112412, mockRng), (12412421, mockRng))

     val randIntDouble: Rand[(Int, Double)] =
       Excercise0606.both(Excercise0601.nonNegativeInt, Excercise0602.double)

     val (result1, rng1) = randIntDouble(mockRng)
     val (int, double) = result1
     assert(int > 0 && (double > 0.0 && double < 1.0))
   }

 }
