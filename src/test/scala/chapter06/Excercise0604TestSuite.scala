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
class Excercise0604TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

   test("test ints") {
     val mockRng = mock[RNG]
     when(mockRng.nextInt).thenReturn((1, mockRng), (2, mockRng), (3, mockRng), (4, mockRng))

     val (list, rng) = chapter06.Excercise0604.ints(4)(mockRng)
     assert(list == List(1, 2, 3, 4))
   }
}
