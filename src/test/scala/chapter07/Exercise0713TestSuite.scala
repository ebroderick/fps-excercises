package chapter07

import chapter07.Chapter07Par1.Par
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
  * Created by ebroderick on 1/29/16.
  */
@RunWith(classOf[JUnitRunner])
class Exercise0713TestSuite extends FunSuite {

  test("testChoiceNViaChooser") {
    val e = new ExecutorService
    val p1 = Par.unit(1)
    val p2 = Par.unit(2)
    val p3 = Par.unit(3)

    val c = Par.choiceNViaChooser(Par.unit(1))(List(p1, p2, p3))
    assert(Par.run(e)(c).get == 2)
  }

  test("testChoiceViaChooser") {
    val e = new ExecutorService
    val t = Par.unit("true")
    val f = Par.unit("false")

    val c = Par.choiceViaChooser(Par.unit(false))(t, f)
    assert(Par.run(e)(c).get == "false")
  }
}
