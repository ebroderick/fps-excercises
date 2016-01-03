package misc

/**
  * @author brodericke
  */
object Lazy {

  def main(args: Array[String]) {
    nonStrict({ println("evaluating arg") })
  }


  def nonStrict[A](a: => A) = { println("calling strict"); anotherNonStrict(strict(a)) }
  def strict[A](a: A): A = a
  def anotherNonStrict[A](a: => A) = println("anothernonstrict")
}
