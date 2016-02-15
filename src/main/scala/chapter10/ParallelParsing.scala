package chapter10

import chapter10.Exercise1001.Monoid

/**
  * Created by ebroderick on 2/10/16.
  */
object ParallelParsing {
  sealed trait WC
  case class Stub(chars: String) extends WC
  case class Part(lStub: String, words: Int, rStub: String) extends WC

  //exercise 10.10
  val wcMonoid = new Monoid[WC] {
      override def op(a1: WC, a2: WC): WC = (a1, a2) match {
        case (Stub(s1), Stub(s2)) => Stub(s1 + s2)
        case (Stub(s1), Part(l, c, r)) => Part(s1 + l, c, r)
        case (Part(l, c, r), Stub(s2)) => Part(l, c, r + s2)
        //case (Part(l1, c1, r1), Part(l2, c2, r2)) => Part(l1, c1 + c2, r2)
        case (Part(l1, c1, r1), Part(l2, c2, r2)) =>
          Part(l1, c1 + (if ((r1 + l2).isEmpty) 0 else 1) + c2, r2)
      }
      override def zero: WC = Stub("")
    }

  //exercise 10.11
  def count(s: String): WC = {
    Exercise1007.foldMapV(s, wcMonoid) {
      case ' ' => Part("", 0, "")
      case c: Char => Stub(c.toString)
    }
  }

  def main(args: Array[String]) {
    println(count("lorem ipsum do"))
  }
}
