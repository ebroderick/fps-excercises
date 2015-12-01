package chapter04

/**
  * Created by brodericke on 11/30/15.
  */
object Exercise0404 {
  import Exercise0401._

  def sequence[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Some(x) :: Nil => Some(List(x))
    case Some(x) :: xs => sequence(xs).flatMap(b => Some(x +: b))
    case None :: xs => None
    case Nil => None
  }

  def sequence2[A](a: List[Option[A]]): Option[List[A]] = a match {
    case Nil => Some(Nil)
    case x :: xs => x.flatMap(a => sequence2(xs).map(b => a :: b))
  }
}
