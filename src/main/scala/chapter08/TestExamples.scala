package chapter08

import chapter08.PropertyBasedTesting.{SGen, Prop, Gen}

/**
  * Created by ebroderick on 2/1/16.
  */
object TestExamples {
  def main(args: Array[String]) {
    proveLaw()
  }

  def proveLaw() {
    println(Prop.run(Prop.check((1 + 2) + 3 == 1 + (2 + 3))))
  }

  def testSortedProp() {
    val smallInt = Gen.choose(-10, 10)
    val maxProp = SGen.forAll(SGen.listOf1(smallInt)) { ns =>
      val sorted = ns.sorted
      if (sorted.size > 1)
        sorted.head <= sorted.last && sorted.forall(sorted.head <= _)
      else true

    }
    println(Prop.run(maxProp))
  }

  def testMaxProp() {
    val smallInt = Gen.choose(-10, 10)
    val maxProp = SGen.forAll(SGen.listOf1(smallInt)) { ns =>
      val max = ns.max
      !ns.exists(_ > max)
    }
    println(Prop.run(maxProp))
  }
}
