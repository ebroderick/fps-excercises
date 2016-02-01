package chapter07

import chapter07.Chapter07Par1.Par
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ebroderick on 1/29/16.
  */
@RunWith(classOf[JUnitRunner])
class Exercise0705TestSuite extends FunSuite {

  test("testSequence") {
    val e = new ExecutorService
    val p1 = Par.lazyUnit( { println("evaluated 1"); 1} )
    val p2 = Par.lazyUnit( { println("evaluated 2"); 2} )
    val p3 = Par.lazyUnit( { println("evaluated 3"); 3} )

    val s = Par.sequence(List(p1, p2, p3))

    assert(s(e).get == List(1, 2, 3))
  }

}
