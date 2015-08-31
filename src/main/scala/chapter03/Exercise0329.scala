package chapter03

object Exercise0329 {

  def fold[A,B](t: Tree[A])(l: A => B)(b: (B,B) => B): B = t match {
    case Leaf(a) => l(a)
    case Branch(lt, rt) => b(fold(lt)(l)(b), fold(rt)(l)(b))
  }

  def sizeViaFold[A](t: Tree[A]): Int = fold(t)(a => 1)((b1, b2) => 1 + b1 + b2)

  def maximumViaFold[A](t: Tree[Int]): Int = fold(t)(a => a)((b1, b2) => b1 max b2)

  def depthViaFold[A](t: Tree[Int]): Int = fold(t)(a => 1)((b1, b2) => if (b1 < b2) 1 + b2 else 1 + b1)

  def mapViaFold[A, B](t: Tree[A])(f: A => B): Tree[B] = fold(t)(a => Leaf(f(a)): Tree[B])((b1, b2) => Branch(b1, b2))
}



