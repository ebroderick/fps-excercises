package chapter03

object Exercise0325 {

  def size[A](t: Tree[A]): Int = t match {
    case Leaf(_) => 1
    case Branch(lt, rt) => 1 + size(lt) + size(rt)
  }
}


