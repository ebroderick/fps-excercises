package chapter07

import chapter07.Chapter07Par1.Par
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ebroderick on 1/29/16.
  */
@RunWith(classOf[JUnitRunner])
class Exercise0714TestSuite extends FunSuite {

  test("testJoin") {
    val e = new ExecutorService
    val j = Par.join(Par.unit(Par.unit(1)))
    assert(Par.run(e)(j).get == 1)
  }

  test("testFlatMapViaJoin") {
    val e = new ExecutorService
    val f = Par.flatMapViaJoin(Par.unit(1))(i => Par.unit(i + 1))
    assert(Par.run(e)(f).get == 2)
  }

  test("testJoinViaFlatMap") {
    val e = new ExecutorService
    val j = Par.joinViaFlatMap(Par.unit(Par.unit(1)))
    assert(Par.run(e)(j).get == 1)
  }
}
