package chapter02

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Exercise0202TestSuite extends FunSuite {
  test("testIsSorted") {
    assert(Exercise0202.isSorted(Array[Int](), (a: Int, b: Int) => a < b))
    assert(Exercise0202.isSorted(Array[Int](1), (a: Int, b: Int) => a < b))
    assert(Exercise0202.isSorted(Array[Int](1, 2, 3, 10), (a: Int, b: Int) => a < b))
    assert(!Exercise0202.isSorted(Array[Int](2, -2), (a: Int, b: Int) => a < b))
  }

  test("testIsSorted2") {
    assert(Exercise0202.isSorted2(Array[Int](), (a: Int, b: Int) => a < b))
    assert(Exercise0202.isSorted2(Array[Int](1), (a: Int, b: Int) => a < b))
    assert(Exercise0202.isSorted2(Array[Int](1, 2, 3, 10), (a: Int, b: Int) => a < b))
    assert(!Exercise0202.isSorted2(Array[Int](2, -2), (a: Int, b: Int) => a < b))
  }
}