package chapter03

object Exercise0328 {

  def map[A, B](t: Tree[A])(f: A => B): Tree[B] = t match {
    case Leaf(a) => Leaf(f(a))
    case Branch(lt, rt) => Branch(map(lt)(f), map(rt)(f))
  }
}


