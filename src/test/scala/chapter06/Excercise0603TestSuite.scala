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
class Excercise0603TestSuite extends FunSuite with BeforeAndAfter with MockitoSugar {

   test("test intDouble") {
     val mockRng = mock[RNG]
     when(mockRng.nextInt).thenReturn((-112412, mockRng), (178312, mockRng))

     val ((int, double), g) = chapter06.Excercise0603.intDouble(mockRng)

     assert(int > 0)
     assert(double > 0.0 && double < 1.0)
   }

  test("test doubleInt") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((-112412, mockRng), (178312, mockRng))

    val ((double, int), g) = chapter06.Excercise0603.doubleInt(mockRng)

    assert(int > 0)
    assert(double > 0.0 && double < 1.0)
  }

  test("test double3") {
    val mockRng = mock[RNG]
    when(mockRng.nextInt).thenReturn((-112412, mockRng), (178312, mockRng), (Int.MinValue, mockRng))

    val ((double1, double2, double3), g) = chapter06.Excercise0603.double3(mockRng)

    assert(double1 > 0.0 && double1 < 1.0)
    assert(double2 > 0.0 && double2 < 1.0)
    assert(double3 > 0.0 && double3 < 1.0)
  }
}
