package chapter10

/**
  * Created by ebroderick on 2/9/16.
  */
object Exercise1002 {

  import Exercise1001.Monoid

  def optionMonoid[A]: Monoid[Option[A]] = new Monoid[Option[A]] {
    override def op(a1: Option[A], a2: Option[A]): Option[A] = a1 orElse a2
    override def zero: Option[A] = None
  }
}
