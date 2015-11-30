package chapter03

/**
  * @author brodericke
  */
object Exercise0329 {

  def fold[A,B](t: Tree[A])(l: A => B)(b: (B,B) => B): B = t match {
    case Leaf(x) => l(x)
    case Branch(left, right) => b(fold(left)(l)(b), fold(right)(l)(b))
  }

  def sizeViaFold[A](t: Tree[A]): Int = fold(t)(_ => 1)(_ + _ + 1)

  def maximumViaFold(t: Tree[Int]): Int = fold(t)(identity)(_ max _)

  def depthViaFold[A](t: Tree[A]): Int = fold(t)(_ => 1)((b1, b2) => 1 + (b1 max b2))

  def mapViaFold[A, B](t: Tree[A])(f: A => B): Tree[B] = fold(t)(a => Leaf(f(a)): Tree[B])((b1, b2) => Branch(b1, b2))
}
