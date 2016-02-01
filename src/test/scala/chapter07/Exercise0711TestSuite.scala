package chapter07

import chapter07.Chapter07Par1.Par
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ebroderick on 1/29/16.
  */
@RunWith(classOf[JUnitRunner])
class Exercise0711TestSuite extends FunSuite {

  test("testChoiceN") {
    val e = new ExecutorService
    val p1 = Par.unit(1)
    val p2 = Par.unit(2)
    val p3 = Par.unit(3)

    val c = Par.choiceN(Par.unit(1))(List(p1, p2, p3))
    assert(Par.run(e)(c).get == 2)
  }

  test("testChoice") {
    val e = new ExecutorService
    val t = Par.unit("true")
    val f = Par.unit("false")

    val c = Par.choice(Par.unit(false))(t, f)
    assert(Par.run(e)(c).get == "false")
  }
}
