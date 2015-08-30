package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0202TestSuite extends FunSuite {

  test("isSorted") {
    val f: (Int, Int) => Boolean = (x: Int, y: Int) => x < y

    assert(Exercise0202.isSorted(Array[Int](), f))
    assert(Exercise0202.isSorted(Array[Int](1), f))
    assert(Exercise0202.isSorted(Array[Int](1, 2, 3), f))
    assert(!Exercise0202.isSorted(Array[Int](3, 2), f))
  }

  test("isSorted2") {
    val f: (Int, Int) => Boolean = (x: Int, y: Int) => x < y

    assert(Exercise0202.isSorted2(Array[Int](), f))
    assert(Exercise0202.isSorted2(Array[Int](1), f))
    assert(Exercise0202.isSorted2(Array[Int](1, 2, 3), f))
    assert(!Exercise0202.isSorted2(Array[Int](3, 2), f))
  }
}