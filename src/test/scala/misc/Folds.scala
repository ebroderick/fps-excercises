package misc

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

/**
 * Created by brodericke on 8/25/15.
 */
@RunWith(classOf[JUnitRunner])
class Folds extends FunSuite {
    test("foldRight") {
      val l = List(1, 2, 3, 4, 5)
      l.foldRight(0)((a, b) => {
        println(s"process $a")
        a + b
      })
    }
    test("foldLeft") {
      val l = List(1, 2, 3, 4, 5)
      l.foldLeft(0)((b, a) => {
        println(s"process $a")
        a + b
      })
    }
}
