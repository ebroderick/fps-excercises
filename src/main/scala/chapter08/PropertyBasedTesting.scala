package chapter08

import chapter05.Chapter05._
import chapter06.{SimpleRNG, Exercise0602, Exercise0601, RNG}
import chapter06.Exercise0610._
import chapter08.PropertyBasedTesting.Prop.{MaxSize, TestCases, FailedCase, SuccessCount}


/**
  * Created by ebroderick on 2/1/16.
  */
object PropertyBasedTesting {

  case class Gen[A](sample: State[RNG, A]) {
    //Exercise 8.6
    def flatMap[B](f: A => Gen[B]): Gen[B] = Gen(sample.flatMap(a => f(a).sample))
    def listOfN(size: Gen[Int]): Gen[List[A]] =
      size.flatMap(i => Gen(State.sequence(List.fill(i)(sample))))

    //exercise 8.10
    def unsized: SGen[A] = SGen(_ => this)
  }

  object Gen {
    def listOf[A](a: Gen[A]): Gen[List[A]] = ???
    //def listOfN[A](n: Int, a: Gen[A]): Gen[List[A]] = ???

    def forAll[A](as: Gen[A])(f: A => Boolean): Prop = Prop {
      (m, n, rng) => randomStream(as)(rng).zip(Stream.from(0)).take(n).map {
        case (a, i) => try {
          if (f(a)) Passed else Falsified(a.toString, i)
        } catch {
          case e: Exception => Falsified(buildMsg(a, e), i)
        }
      }.find(_.isFalsified).getOrElse(Passed)
    }

    def randomStream[A](g: Gen[A])(rng: RNG): Stream[A] =
      Stream.unfold(rng)(rng => Some(g.sample.run(rng)))

    def buildMsg[A](s: A, e: Exception): String =
      s"test case: $s\ngenerated an exception: ${e.getMessage}\nstack trace:\n" +
      s" ${e.getStackTrace.mkString}"

    //Exercise 8.4
    def choose(start: Int, stopExclusive: Int): Gen[Int] =
      Gen(State(Exercise0601.nonNegativeInt).map(i => start + i % (stopExclusive - start)))

    //Exercise 8.5
    def unit[A](a: => A): Gen[A] = Gen(State.unit(a))

    def boolean: Gen[Boolean] =
      /*Gen(State(rng => {
        val (i, nextRng) = rng.nextInt
        (i > 0, nextRng)
      }))*/
      Gen(State(Exercise0601.nonNegativeInt).map(_ > 0))

    def listOfN[A](n: Int, g: Gen[A]): Gen[List[A]] = {
      /*Gen(State(rng => {
        (1 to n).foldLeft((List[A](), rng)) {
          case (t, _) => {
            val (l, s) = t
            val (a, ns) = g.sample.run(s)
            (a :: l, ns)
          }
        }
      }))*/
      Gen(State.sequence(List.fill(n)(g.sample)))
    }

    //Exercise 8.7
    def union[A](g1: Gen[A], g2: Gen[A]): Gen[A] = boolean.flatMap(if (_) g1 else g2)

    //Exercise 8.8
    def weighted[A](g1: (Gen[A], Double), g2: (Gen[A], Double)): Gen[A] = {
      val g1Threshold = g1._2.abs / (g1._2.abs + g2._2.abs) // from answer set...
      Gen(State(Exercise0602.double).flatMap(d =>
        if (d < g1Threshold) g1._1.sample else g2._1.sample))
    }

  }

  case class Prop(run: (MaxSize, TestCases, RNG) => Result) {
    //Exercise 8.3
    /*def check: Boolean
    def &&(p: Prop): Prop = {
      //val t = this
      new Prop {
        def check: Boolean = Prop.this.check && p.check
      }
    }*/

    //exercise 8.9
    def &&(p: Prop): Prop = Prop {
      (m, tc, s) => Prop.this.run(m, tc, s) match {
        case Passed | Proved => p.run(m, tc, s)
        case f => f
      }
    }

    def ||(p: Prop): Prop = Prop {
      (m, tc, s) =>
        Prop.this.run(m, tc, s) match {
          case Passed | Proved => Passed
          case _ => p.run(m, tc, s)
        }
      }

  }

  object Prop {
    type SuccessCount = Int
    type FailedCase = String
    type TestCases = Int
    type MaxSize = Int

    def run(p: Prop,
            maxSize: Int = 100,
            testCases: Int = 100,
            rng: RNG = SimpleRNG(System.currentTimeMillis)): Unit =
      p.run(maxSize, testCases, rng) match {
        case Falsified(msg, n) =>
          println(s"! Falsified after $n passed tests:\n $msg")
        case Passed =>
          println(s"+ OK, passed $testCases tests.")
        case Proved =>
          println(s"+ OK, proved property")
    }

    def check(p: => Boolean): Prop = Prop { (_, _, _) =>
      if (p) Proved else Falsified("()", 0)
    }
  }

  sealed trait Result {
    def isFalsified: Boolean
  }

  case object Passed extends Result {
    def isFalsified = false
  }

  case object Proved extends Result {
    def isFalsified: Boolean = false
  }

  case class Falsified(failure: FailedCase, successes: SuccessCount) extends Result {
    def isFalsified = true
  }

  case class SGen[A](forSize: Int => Gen[A]) {
    //exercise 8.11
    def flatMap[B](f: A => Gen[B]): SGen[B] = SGen {
      i => forSize(i).flatMap(a => f(a))
    }
  }

  object SGen {
    def listOf[A](g: Gen[A]): SGen[List[A]] = SGen(i => Gen.listOfN(i, g))

    def listOf1[A](g: Gen[A]): SGen[List[A]] = SGen(i => Gen.listOfN(i max 1, g))

    def forAll[A](g: SGen[A])(f: A => Boolean): Prop = forAll(g.forSize)(f)

    def forAll[A](g: Int => Gen[A])(f: A => Boolean): Prop = Prop {
      (m, n, rng) =>
        val casesPerSize = (n + (m - 1)) / m
        val props: Stream[Prop] =
          Stream.from(0).take(n.min(m) + 1).map(i => Gen.forAll(g(i))(f))
        val prop: Prop =
          props.map(p => Prop { (m2, n2, rng2) =>
            p.run(m2, casesPerSize, rng)
          }).toList.reduce(_ && _)
        prop.run(m, n, rng)
    }

  }
}
