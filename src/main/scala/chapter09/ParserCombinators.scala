package chapter09

import chapter08.PropertyBasedTesting.{Prop, Gen}

import language.higherKinds
import language.implicitConversions
import scala.util.matching.Regex

/**
  * Created by ebroderick on 2/2/16.
  */
object ParserCombinators {

  /*
  def main(args: Array[String]) {
    val P: Parsers = implicitly[Parsers]
    import P._

    val p = "asdf" | "asdf"
    map(many(char('a')))(_.size)
    val numA = char('a').many.map(_.size)

    if (false) println("asf")

  }

  //exercise 9.6
  def parseSingleDigitFollowedByThatManyACharacters() = {
    val P: Parsers = implicitly[Parsers]
    import P._

    for {
      digit <- "^[0-9]+".r
      n <- listOfN(digit.toInt, char('a'))
    } yield n
  }


  trait Parsers[ParseError, Parser[+_]] { self =>
    def run[A](p: Parser[A])(input: String): Either[ParseError, A]
    def char(c: Char): Parser[Char] = string(c.toString).map(_.charAt(0))
    def or[A](s1: Parser[A], s2: => Parser[A]): Parser[A]
    def listOfN[A](n: Int, p: Parser[A]): Parser[List[A]]
    //def many[A](p: Parser[A]): Parser[List[A]]
    //def map[A, B](a: Parser[A])(f: A => B): Parser[B]
    def succeed[A](a: A): Parser[A] = string("").map(_ => a)
    def slice[A](p: Parser[A]): Parser[String]
    //def many1[A](p: Parser[A]): Parser[List[A]]
    //def product[A, B](p: Parser[A], p2: => Parser[B]): Parser[(A, B)]

    //exercise 9.1
    //def map2[A,B,C](p: Parser[A], p2: => Parser[B])(f: (A,B) => C): Parser[C] =
      //product(p, p2).map(t => f(t._1, t._2))
      //product(p, p2).map(f.tupled)
    def many1[A](p: Parser[A]): Parser[List[A]] =
      map2(p, many(p))(_ :: _)

    //exercise 9.3
    /**
      * recognizes zero or more repetitions of the character 'a' and
      * returns the number of characters it has seen
      *
      * run(char('a').many)("aaba") == List('a', 'a', 'a')
      *
      * @param p
      * @tparam A
      * @return
      */
    def many[A](p: Parser[A]): Parser[List[A]] =
      map2(p, many(p))(_ :: _) or succeed(List())

    def flatMap[A, B](p: Parser[A])(f: A => Parser[B]): Parser[B]

    //exercise 9.7
    def product[A, B](p: Parser[A], p2: => Parser[B]): Parser[(A, B)] =
      //p.flatMap(a => p2.map(b => (a, b)))
      for { a <- p; b <- p2 } yield (a, b)

    def map2[A,B,C](p: Parser[A], p2: => Parser[B])(f: (A,B) => C): Parser[C] =
      for { a <- p; b <- p2 } yield f(a, b)

    //exercise 9.8
    def map[A, B](a: Parser[A])(f: A => B): Parser[B] =
      flatMap(a)(a => succeed(f(a)))

    implicit def string(s: String): Parser[String]
    implicit def regex(r: Regex): Parser[String]
    implicit def operators[A](p: Parser[A]): ParserOps[A] = ParserOps[A](p)
    implicit def asStringParser[A](a: A)(implicit f: A => Parser[String]):
      ParserOps[String] = ParserOps(f(a))

    case class ParserOps[A](p: Parser[A]) {
      def |[B>:A](p2: Parser[B]): Parser[B] = self.or(p, p2)
      def or[B>:A](p2: Parser[B]): Parser[B] = self.or(p, p2)
      def many = self.many(p)
      def slice: Parser[String] = self.slice(p)
      def map[B](f: A => B): Parser[B] = self.map(p)(f)
      def **[B](p2: Parser[B]): Parser[(A, B)] = self.product(p, p2)
      def product[B](p2: Parser[B]): Parser[(A, B)] = self.product(p, p2)
      def flatMap[B](f: A => Parser[B]): Parser[B] = self.flatMap(p)(f)
    }

    object Laws {
      def equal[A](p1: Parser[A], p2: Parser[A])(in: Gen[String]): Prop =
        Gen.forAll(in)(s => run(p1)(s) == run(p2)(s))
      def mapLaw[A](p: Parser[A])(in: Gen[String]): Prop =
        equal(p, p.map(a => a))(in)
    }
  }

  def jsonParser[Err, Parser[+_]](P: Parsers[Err, Parser]): Parser[JSON] = {
    import P._
    val spaces = char(' ').many.slice
    ???
  }

  trait JSON

  object JSON {
    case object JNull extends JSON
    case class JNumber(get: Double) extends JSON
    case class JString(get: String) extends JSON
    case class JBool(get: Boolean) extends JSON
    case class JArray(get: IndexedSeq[JSON]) extends JSON
    case class JObject(get: Map[String, JSON]) extends JSON
  }
  */
}
