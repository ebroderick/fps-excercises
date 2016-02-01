package chapter07

import chapter07.Chapter07Par1.Par
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ebroderick on 1/29/16.
  */
@RunWith(classOf[JUnitRunner])
class Exercise0706TestSuite extends FunSuite {

  test("testParFilter") {
    val e = new ExecutorService
    val s = Par.parFilter(List(1, 2, 3))(_ != 2)

    assert(s(e).get == List(1, 3))
  }

}
